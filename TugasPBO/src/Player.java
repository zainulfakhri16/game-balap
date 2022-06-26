/**
 * player
 */
public class Player {
    racecars car = new racecars();
    private String name;
    private boolean win;


    Player(String name){
        this.name = name;
    }

    public void ShowInfo() {
        System.out.println("Name : "+getName()+"\tCar : "+getCar().getName());
    }

    public void importPlayer(String carbrand){
        getCar().setName(carbrand);
    }



    public racecars getCar() {
        return car;
    }
    
    public void setCar(racecars car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    
}