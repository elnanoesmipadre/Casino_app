import java.util.Scanner;

class Roulette{
    static void resume_screen(Scanner scanner){
        System.out.println("¿Quieres seguir jugando?");
        String resume = scanner.nextLine().trim().toLowerCase();
        if (resume.equals("sí") || resume.equals("si")) {
        } else if (resume.equals("no")) {
            System.out.println("¡Gracias por jugar!");
            System.exit(0);
        } else {
            System.out.println("Por favor, contesta sí o no");
            resume_screen(scanner);
        }
    }// This is for asking if the user wants to continue betting or not

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        var credits = 1500;
        while(true){
            int num = (int)(Math.random()*36);
            int color = (int)(Math.random());
            int dozen = (int)(Math.random()*2)+1;
            int even_odd = num % 2;
            //Putting some results

            if(credits <= 0){
                System.out.println("Te has quedado sin dinero. Fin de la partida.");
                System.exit(0);
                //Finishing the game if the user doesn't have any credits
            
            }else{
                System.out.println("Juguemos a la ruleta.");
                System.out.println("Tienes " + credits + " monedas. ¿Cuanto dinero quieres apostar?");
                int bet = scanner.nextInt();
                scanner.nextLine();
                if(bet > credits){
                    System.out.println("No puedes apostar más de lo que tienes. Inténtalo de nuevo.");
                    continue;
                }else if(bet <= 0){
                    System.out.println("No puedes apostar 0 creditos o menos. Inténtalo de nuevo.");
                    continue;
                }else{
                    credits -= bet;
                }

                System.out.println("¿Jugamos a números (1), a color (2), a docenas (3) o a pares/impares (4)?");
                int election = scanner.nextInt();
                scanner.nextLine();
                //choosing the mode
                
                if(election == 1){
                    System.out.println("A qué número apuestas?");
                    int num_elegido = scanner.nextInt();
                    scanner.nextLine();
                    if(num_elegido == num){
                        System.out.println("¡Has ganado!");
                        credits += bet * 35;
                        resume_screen(scanner);
                    }else{
                        System.out.println("¡Has perdido! Había tocado el nº " + num);
                        resume_screen(scanner);
                    }
                }else if(election == 2){
                    System.out.println("¿Rojo (0) o Negro? (1)");
                    int col_elegido = scanner.nextInt();
                    scanner.nextLine();
                    if(col_elegido == color ){
                        System.out.println("¡Has acertado!");
                        credits += bet * 2;
                        resume_screen(scanner);
                    }else if(col_elegido != color && color == 0){
                        System.out.println("Has fallado, había tocado rojo");
                        resume_screen(scanner);
                    }else if(col_elegido != color && color == 1){
                        System.out.println("Has fallado, había tocado negro");
                        resume_screen(scanner);
                    }
                }
            }
        }
    }
}
