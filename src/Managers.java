import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Managers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int iterations = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < iterations; i++) {
			ArrayList<Worker> allWorkers = new ArrayList<>();
			int managers = Integer.parseInt(scan.nextLine());
			for (int j = 0; j < managers; j++) {
				String managerName = scan.nextLine();
				int numWorkers = Integer.parseInt(scan.nextLine());
				//check if there is a worker with this name
				Worker worker = null;
				for (int k = 0; k < allWorkers.size(); k++) {
					if(allWorkers.get(k).name.equals(managerName)){
						worker = allWorkers.get(k);
						break;
					}
				}
				if(worker == null){
					worker = new Worker(managerName, null);
					allWorkers.add(worker);
				}
				for (int k = 0; k < numWorkers; k++) {
					String workerName = scan.nextLine();
					//check if there is a worker with this name
					Worker worker2 = null;
					for (int l = 0; l < allWorkers.size(); l++) {
						if(allWorkers.get(l).name.equals(workerName)){
							worker2 = allWorkers.get(l);
							break;
						}
					}
					if(worker2==null){
						worker2 = new Worker(workerName, worker);
						allWorkers.add(worker2);
					}
					worker2.boss = worker;
				}
			}
			Collections.sort(allWorkers);
			for (Worker worker : allWorkers){

					Worker temp = worker;
					System.out.print(temp.name);
					while(temp.boss != null){
						temp = temp.boss;
						System.out.print("/" + temp.name);
					}
					System.out.println();

			}
		}
	}
}

class Worker implements Comparable<Worker>{
	String name;
	Worker boss;

	public Worker(String name, Worker boss){
		this.name = name;
		this.boss = boss;
	}

	public boolean isCEO(){
		return boss == null;
	}

	public int compareTo(Worker other){
		//acend by name
		return this.name.compareTo(other.name);
	}

	public String toString() {
		return name;
	}
}
