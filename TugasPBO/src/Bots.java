public class Bots {
    private String name;
    
    Bots(String name){
        this.name = name;
    }

    racecars botcar1 = new racecars();


    public void importBot1(String carbrand) {
        getBotcar1().setName(carbrand);
    }
    
    public void showBot1Info() {
        System.out.println("Name : Bot 1"+"\tCar : "+getBotcar1().getName());
    }


    public racecars getBotcar1() {
        return botcar1;
    }

    public void setBotcar1(racecars botcar1) {
        this.botcar1 = botcar1;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
