import java.util.Random;

class Horse extends Thread {

	Random random = new Random();
	private static final int raceLength = 100;
	private static final int barnGateLength = 10;
	private static String winnerName = "";
	private int jump;
	private int leap;
	private String name = "";
	private String warCry = "";
	Horse[] horse;

	public Horse(String warCry) {
		this.warCry = warCry;
		jump = 0;
	}

	public Horse(Horse[] horse) {
		this.horse = horse;
	}

	public static String getWinnerName() {
		return winnerName;
	}

	public int getDistance() {
		return jump;
	}

	public String horseName() {
		return name;
	}

	public void StartBarnToGate() {
		while (leap < barnGateLength) {
			int randomNum = 1 + random.nextInt(10);
			leap += randomNum;
			System.out.println(getName() + " distance is " + leap);

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				System.out.println(e);
			}

			if (leap >= barnGateLength) {
				System.out.println(getName() + " ready!");
				try {
					synchronized (this) {
						Horse.class.wait();
					}
				} catch (InterruptedException e) {
				} catch (IllegalMonitorStateException e) {
				}

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
		}
	}

	public void StartGateToFinishLine() {

		while (jump < raceLength) {

			try {
				synchronized (this) {
				Thread.currentThread().notifyAll();
				}
			} catch (IllegalMonitorStateException e) {
			}

			int randomJump = 1 + random.nextInt(10);
			//int randomBoost = 1 + random.nextInt(20);
			jump += randomJump;
			System.out.println(getName() + " distance is " + jump);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}


	public void run() {

		StartBarnToGate();

		System.out.println(getName() + " starts running...");

		StartGateToFinishLine();

		System.out.println(warCry);

	}



}
