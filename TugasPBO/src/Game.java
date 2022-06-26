import java.util.Random;
import java.util.Scanner;
import java.io.*;

/**
 * Game
 */
public class Game {
    Scanner scan = new Scanner(System.in);
    Player player;
    Bots bot1;
    Maps map1, map2, map3, map4, map5;
    String myInput;
    // int race = 3;

    public void login() {
        System.out.println();
        System.out.println("Welcome to the race game!\n======================");
        System.out.print("Untuk memulai permainan, Anda harus memasukkan nama Anda.\nNama Anda:");
        player = new Player(scan.nextLine());
        bot1 = new Bots("Bot 1");

        System.out.println("\n\n\n");
        System.out.println("Pilih Mobil Anda\n==============");
        System.out.println("1-Audi");
        System.out.println("2-BMW");
        System.out.println("3-Mercedes");
        System.out.println("4-BMW M8 GTE");
        System.out.println("5-Ferrari 488");
        System.out.print("Pilihan Anda:");
        int carselect = scan.nextInt();
        while (carselect > 3 || carselect < 1) {
            System.out.println("Mobil ini tidak ada. Silakan masukkan Nomor yang ada");
            System.out.print("Pilihan Anda:");
            carselect = scan.nextInt();
        }
        switch (carselect) {
            case 1:
                player.importPlayer("Audi R8");
                bot1.importBot1("BMW M4");
                break;
            case 2:
                player.importPlayer("BMW M4");
                bot1.importBot1("Audi R8");
                break;
            case 3:
                player.importPlayer("AMG GTR");
                bot1.importBot1("Audi R8");
                break;
            case 4:
                player.importPlayer("BMW M8 GTE");
                bot1.importBot1("AMG GTR");
                break;
            case 5:
                player.importPlayer("Ferrari 488");
                bot1.importBot1("AMG GTR");
                break;
            default:
                break;
        }
        System.out.println();
        System.out.println("=================================Racers==================================");
        player.ShowInfo();
        bot1.showBot1Info();
        System.out.println("=========================================================================");

    }

    public void start() throws IOException {
        map1 = new Maps("Germany");
        map2 = new Maps("USA");
        map3 = new Maps("England");
        map4 = new Maps("Turkey");
        map5 = new Maps("Canada");

        while (map1.isfinished != true || map2.isfinished != true || map3.isfinished != true || map4.isfinished != true
                || map5.isfinished != true) {

            // System.out.println();
            System.out.println("===========Maps===========");
            System.out.println("1-Germany\n2-USA\n3-England\n4-Turkey\n5-Canada");
            System.out.println("==========================");
            System.out.print("Select the map:");
            int mapSelection = scan.nextInt();

            while (mapSelection > 5 || mapSelection < 1) {
                System.out.println("This ID does not exist. Please enter a ID that exists");
                System.out.print("Select the map:");
                mapSelection = scan.nextInt();
            }

            switch (mapSelection) {
                case 1:
                    race(map1);
                    // race--;
                    map1.isfinished = true;
                    break;
                case 2:
                    race(map2);
                    // race--;
                    map2.isfinished = true;
                    break;
                case 3:
                    race(map3);
                    // race--;
                    map3.isfinished = true;
                    break;
                case 4:
                    race(map4);
                    map4.isfinished = true;
                    break;
                case 5:
                    race(map5);
                    map5.isfinished = true;
                    break;
                default:
                    break;
            }
        }

        System.out.println("\n\n\n\n\n");
        System.out.println("All races are completed!!!!!!");
    }

    private void race(Maps map) throws IOException {
        System.out.println("\n\n\n\n\n\n\n\n");
        System.out.println("==========================================");
        System.out.println("Welcome the the " + map.getName());
        System.out.println("The race started now !!!");
        //

        String sGame = "y"; // user harus menekan y atau Y untuk bermain,agar menjadi patokan game dimulai
        System.out.print("\nApakah Anda ingin bermain? Y or N  > ");
        System.out.print("\n");
        while (sGame.equals("y") || sGame.equals("Y")) // jika user menekan y, maka program ke method startGame
        {
            sGame = dadu(sGame); // permainan dimulai dengan menjalankan method startGame
        }
        System.out.println("\n\n\t\t\t\tSAMPAI JUMPA LAGI!");
    }

    public String dadu(String start) throws IOException {
        player = new Player(scan.nextLine());
        int playerPosition = 1;
        int bot1Position = 1;
        int diceroll = 0;
        int diceroll2 = 0;
        int playerroll = 1;
        int bot1roll = 1;
        String playAgain = "y";

        while (playAgain.equals("y") || playAgain.equals("Y")) {
            int tantangan[] = new int[6];
            tantangan[0] = 54;
            tantangan[1] = 90;
            tantangan[2] = 6;
            tantangan[3] = 9;
            tantangan[4] = 40;
            tantangan[5] = 67;

            playerroll = getDice(diceroll, diceroll2);
            bot1roll = getDice(diceroll, diceroll2);
            playerPosition = playerPosition + playerroll;
            bot1Position = bot1Position + bot1roll;
            playerPosition = getP(playerPosition, playerroll, tantangan);
            bot1Position = botget(bot1Position, bot1roll, tantangan, playerPosition);
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("\t\t\t\t\t-----------------------------------------");
            System.out.println("\t\t\t\t\t|\tHasil lemparan dadu Anda:" + playerroll + "\t\t\t|\t");
            System.out.println("\t\t\t\t\t|\tHasil lemparan dadu Komputer: " + bot1roll + "\t\t|\t");
            System.out.println("\t\t\t\t\t-----------------------------------------");
            // playerPosition=getP
            System.out.println("\t\t\t*****************************************************");
            System.out.println("\t\t\t*\t\tAnda sekarang berada di kotak " + playerPosition + "\t\t\t*");
            System.out.println("\t\t\t*\t\tKomputer sekarang berada di kotak " + bot1Position + "\t\t*");
            System.out.println("\t\t\t*****************************************************");

            // jika permainan sudah berakhir dan user ingin bermain lagi
            if (playerPosition == 100 || bot1Position == 100) {
                playerPosition = 1;
                bot1Position = 1;
                System.out.print("\nApakah Anda ingin bermain2 lagi? Y or N  > ");
                player = new Player(scan.nextLine());
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n");
            }
            // melanjutkan permainan jika belum menang
            else {
                System.out.print("\nApakah Anda ingin melanjutkan1 permainan? Y or N  > ");
                player = new Player(scan.nextLine());
            }

        }
        return playAgain;
    }

    public static int getDice(int diceroll, int diceroll2) {
        diceroll = (int) (Math.random() * 3) + 1;
        diceroll2 = (int) (Math.random() * 3) + 1;
        int move = diceroll + diceroll2;
        return move; // return parameter move akan membawa hasil diceroll ke startGame
    }

    public static int getP(int playerPosition, int playerroll, int[] tantangan) throws IOException {

        

        if (playerPosition < 0 || playerPosition > 112) {
            System.out.println("TERJADI EROR");
        } else if (playerPosition > 100) // jika posisi user melebihi 100
        {
            playerPosition = playerPosition - playerroll; // user tidak bergerak
            System.out.println("Hasil lemparan mu melebihi 100, kamu tidak bergerak!");
        } else if (playerPosition == 100) {
            System.out.println("SELAMAT ANDA MEMENANGKAN PERMAINAN!!");
        }
        return playerPosition;
    }

    public static int botget(int bot1Position, int bot1roll, int[] tantangan, int playerPosition) throws IOException {

        if (bot1Position < 0 || bot1Position > 112) {
            System.out.println("TERJADI EROR");
        } else if (bot1Position > 100) {
            bot1Position = bot1Position - bot1roll;
            System.out.println("Lemparan dadu computer melebihi 100, tidak bergerak!");
        } else if (bot1Position == 100 && playerPosition != 100) {
            System.out.println("COMPUTER MEMENANGKAN PERMAINAN!");
        }
        return bot1Position;
    }
}