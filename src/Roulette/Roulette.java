import java.util.Scanner;

class Roulette{
    static void resume_screen(Scanner input){
        System.out.println("¿Quieres seguir jugando?");
        String resume = input.nextLine().trim().toLowerCase();
        switch (resume) {
            case "sí", "si":
                break;
            case "no":
                System.out.println("¡Gracias por jugar!");
                System.exit(0);
            default:
                System.out.println("Por favor, contesta sí o no");
                resume_screen(input);
        }
    }// This is for asking if the user wants to continue betting or not

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        var credits = 1500;
        System.out.println("Juguemos a la ruleta.");
        while(true){
            int num = (int)(Math.random()*37);
            int color = (int)(Math.random()*2);
            int dozen = (int)(Math.random()*3)+1;
            int even_odd = num % 2;
            //Putting some results

            if(credits <= 0){
                System.out.println("Te has quedado sin dinero. Fin de la partida.");
                System.exit(0);
                //Finishing the game if the user doesn't have any credits
            
            }else{
                
                System.out.println("Tienes " + credits + " monedas. ¿Cuanto dinero quieres apostar?");
                int bet = input.nextInt();
                input.nextLine();
                if(bet > credits){
                    System.out.println("No puedes apostar más de lo que tienes. Inténtalo de nuevo.");
                    continue;
                }else if(bet <= 0){
                    System.out.println("No puedes apostar 0 creditos o menos. Inténtalo de nuevo.");
                    continue;
                }else{
                    credits -= bet;
                }

                System.out.println("¿Jugamos a números, a color, a docenas, a pares o a impares?");
                String election = input.nextLine().trim().toLowerCase();
                //choosing the mode
                switch(election){
                    case "números", "numeros", "a numeros", "a números":
                        boolean validNum = false;
                        while(!validNum){
                            System.out.println("A qué número apuestas?");
                            int num_elegido = input.nextInt();
                            input.nextLine();
                            if(num_elegido == num && num_elegido <= 36 && num_elegido >= 0){
                                System.out.println("¡Has ganado!");
                                credits += bet * 35;
                                resume_screen(input);
                                validNum = true;
                            }else if(num_elegido != num && num_elegido <= 36 && num_elegido >= 0){
                                System.out.println("¡Has perdido! Había tocado el nº " + num);
                                resume_screen(input);
                                validNum = true;
                            }else{
                                System.out.println("Elige un número entre 0 y 36");
                            }
                        }
                        break;
                    case "color", "a color":
                        boolean colorValido = false;
                        while (!colorValido) {
                            System.out.println("¿Rojo o Negro?");
                            String col_elegido = input.nextLine().trim().toLowerCase();
                            if ((col_elegido.equals("rojo") && color == 0) || (col_elegido.equals("negro") && color == 1)) {
                                System.out.println("¡Has acertado!");
                                credits += bet * 2;
                                resume_screen(input);
                                colorValido = true;
                            } else if ((col_elegido.equals("rojo") && color == 1) || (col_elegido.equals("negro") && color == 0)) {
                                if (col_elegido.equals("rojo")) {
                                    System.out.println("¡Has fallado! Había tocado negro");
                                } else {
                                    System.out.println("Lo siento... Había tocado rojo");
                                }
                                resume_screen(input);
                                colorValido = true;
                            } else {
                                System.out.println("Por favor, ingrese rojo o negro");
                                // El bucle repite la pregunta
                            }
                        }
                        break;
                    case "docenas", "a docenas":
                        boolean validDozen = false;
                        while(!validDozen){
                            System.out.println("¿Juegas a la 1ª, a la 2ª o a la 3ª docena?");
                            int dozen_chosen = input.nextInt();
                            input.nextLine();
                            if(dozen_chosen == dozen){
                                System.out.println("¡Has ganado");
                                credits += bet * 5;
                                resume_screen(input);
                                validDozen = true;
                            }else if((dozen_chosen != dozen) && (dozen_chosen <= 3) && (dozen_chosen >= 1)){
                                System.out.println("¡Has fallado! Había tocado la " + dozen + "ª docena");
                                resume_screen(input);
                                validDozen = true;
                            }else{
                                System.out.println("Ingrese 1, 2 o 3");
                            }
                        }
                        break;
                    case "pares", "a pares":
                        if(even_odd == 0){
                            System.out.println("¡Has ganado!");
                            credits += bet * 2;
                            resume_screen(input);
                        }else{
                            System.out.println("¡Has perdido! El número era " + num + ", que es impar.");
                            resume_screen(input);
                        }
                    case "impares", "a impares":
                        if(even_odd == 1){
                            System.out.println("¡Has ganado!");
                            credits += bet * 2;
                            resume_screen(input);
                        }else{
                            System.out.println("¡Has perdido! El número era " + num + ", que es par");
                            resume_screen(input);
                        }
                    default:
                        System.out.println("Por favor, elige una de las opciones disponibles.");
                        credits += bet;
                }
            }
        }
    }
}

