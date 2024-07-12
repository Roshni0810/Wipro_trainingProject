public class HareTortoiseRace {
    public static void main(String[] args) {
        Race race = new Race();
        
        Thread hare = new Thread(new Hare(race), "Hare");
        Thread tortoise = new Thread(new Tortoise(race), "Tortoise");
        
        // Set high priority to Hare
        hare.setPriority(Thread.MAX_PRIORITY);
        tortoise.setPriority(Thread.MIN_PRIORITY);
        
        // Start both threads
        hare.start();
        tortoise.start();
        
        try {
            hare.join();
            tortoise.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Race finished.");
    }
}

class Race {
    private boolean raceWon = false;
    
    public synchronized boolean isRaceWon() {
        return raceWon;
    }
    
    public synchronized void setRaceWon() {
        this.raceWon = true;
    }
}

class Hare implements Runnable {
    private Race race;
    
    public Hare(Race race) {
        this.race = race;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (race.isRaceWon()) {
                System.out.println("Hare stops running as Tortoise already won.");
                break;
            }
            if (i == 60) {
                System.out.println("Hare is sleeping for 1 second.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Hare ran " + i + " meters.");
        }
        if (!race.isRaceWon()) {
            System.out.println("Hare wins the race!");
            race.setRaceWon();
        }
    }
}

class Tortoise implements Runnable {
    private Race race;
    
    public Tortoise(Race race) {
        this.race = race;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (race.isRaceWon()) {
                System.out.println("Tortoise stops running as Hare already won.");
                break;
            }
            System.out.println("Tortoise ran " + i + " meters.");
        }
        if (!race.isRaceWon()) {
            System.out.println("Tortoise wins the race!");
            race.setRaceWon();
        }
    }
}
