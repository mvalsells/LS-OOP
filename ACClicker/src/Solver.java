public class Solver implements Runnable{
    private final String name;
    private final int period;
    private final int price;
    private int timesBought;

    public Solver(String name, int period, int price) {
        this.name = name;
        this.period = period;
        this.price = price;
        timesBought=0;
    }

    private void solve(){
        while (true) {
            Controller.incrementAC();
            try {
                Thread.sleep(period);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        solve();
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getTimesBought() {
        return timesBought;
    }

    public void bought(){
        timesBought++;
    }
}
