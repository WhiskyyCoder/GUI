package zad2;

public class StringTask implements Runnable {
	String napis = "";
    TaskState stan = null;
	Thread watek = new Thread(this);
	int powtorzenia = 0;
	int k = 0;
	String result = "";

	public StringTask(String string, int i) {
		napis = string;
		powtorzenia = i;
		stan = TaskState.CREATED;
	}

	@Override
	public void run() {

		while (k < powtorzenia && !watek.isInterrupted()) {
			result += napis;

			k++;

		}
		if (k == powtorzenia) {
			stan = TaskState.READY;

		}

	}

	public boolean isDone() {
		
		if ((stan == TaskState.ABORTED )|| (stan==TaskState.READY))
			return true;

		return false;
	}

	public String getResult() {

		return result;

	}

	public TaskState getState() {

		return stan;
	}

	public void start() {
		watek.start();
stan=TaskState.RUNNING;
	}

	public void abort() {
		stan=TaskState.ABORTED;
		watek.interrupt();
		
	}

}
