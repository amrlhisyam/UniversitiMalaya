package soalan5;

/**
 *
 * @author Hisyam
 */
public class Main {
    public static void main(String[] args) {
        CloudPackage[] cloudPackage = new CloudPackage[4];
        cloudPackage[0] = new CloudPackage("p2-15", 4, 15, 1.24);
        cloudPackage[1] = new CloudPackage("p2-30", 6, 30, 2.11);
        cloudPackage[2] = new CloudPackage("r5-20", 4, 20, 1.38);
        cloudPackage[3] = new CloudPackage("r6-20", 6, 20, 1.88);

        Job job = new Job("J1", 252, 20);
        Job job2 = new Job("J2", 108, 10);
        Job job3 = new Job("J3", 72, 25);

        int lowest = 0;
        double costLowest = Double.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            if (cloudPackage[i].check(job)) {
                double totalCost = cloudPackage[i].totalCost(job);
                if (totalCost < costLowest) {
                    costLowest = totalCost;
                    lowest = i;
                }
            }
        }
        System.out.println("J1: " + cloudPackage[lowest].toString());

        lowest = 0;
        costLowest = Double.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            if (cloudPackage[i].check(job2)) {
                double totalCost = cloudPackage[i].totalCost(job2);
                if (totalCost < costLowest) {
                    costLowest = totalCost;
                    lowest = i;
                }
            }
        }
        System.out.println("J2: " + cloudPackage[lowest].toString());

        lowest = 0;
        costLowest = Double.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            if (cloudPackage[i].check(job3)) {
                double totalCost = cloudPackage[i].totalCost(job3);
                if (totalCost < costLowest) {
                    costLowest = totalCost;
                    lowest = i;
                }
            }
        }

        System.out.println("J3: " + cloudPackage[lowest].toString());
    }
}

class Cloud {
    String cloudPackage;
    double totalCost;

    public Cloud(String cloudPackage) {
        this.cloudPackage = cloudPackage;
        this.totalCost = 0;
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return String.format("""
                             Cloud Package: %s
                             Total Cost: RM%.2f
                             """,
                cloudPackage, totalCost);
    }
}

class Job {
    String jobName;
    int numberTasks;
    int memory;

    public Job(String jobName, int numberTasks, int memory) {
        this.jobName = jobName;
        this.numberTasks = numberTasks;
        this.memory = memory;
    }

    public String getJobName() {
        return jobName;
    }

    public int getNumberTasks() {
        return numberTasks;
    }

    public int getMemory() {
        return memory;
    }

    @Override
    public String toString() {
        return String.format("""
                         Name of job: %s
                         Number of tasks: %d
                         Memory: %d
                         """,
                jobName, numberTasks, memory);
    }
}

class CloudPackage extends Cloud {
    int numberCore;
    int memory;
    double priceHour;

    public CloudPackage(String cloudPackage, int numberCore, int memory, double priceHour) {
        super(cloudPackage);
        this.numberCore = numberCore;
        this.memory = memory;
        this.priceHour = priceHour;
    }

    public boolean check(Job job) {
        return this.memory >= job.getMemory();
    }

    public double totalCost(Job job) {
        double total = Math.ceil((double) job.getNumberTasks() / this.numberCore);
        this.totalCost = total * this.priceHour;
        return this.totalCost;
    }
}