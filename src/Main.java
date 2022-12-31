import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    List<Arma> Armas = new ArrayList<>();
    private void exibirMenu(){
        System.out.println("\n\n");
        System.out.println("+-------------------------------------------+");
        System.out.println("|        Menu de Opções                     |");
        System.out.println("+-------------------------------------------+");
        System.out.println("| 01 - Cadastrar Arma                       |");
        System.out.println("| 02 - Excluir Arma                         |");
        System.out.println("| 03 - Imprimir relatório de Armas          |");
        System.out.println("| 04 - Imprimir última Arma cadastrada      |");
        System.out.println("| 50 - Exibir o menu de opções              |");
        System.out.println("| 99 - Sair                                 |");
        System.out.println("+-------------------------------------------+");
    }

    private void cadastrarArma(){
        Scanner leitor = new Scanner(System.in);
        Arma Arma = new Arma();

        System.out.print("ID da arma: ");
        Arma.setIdArma(leitor.nextInt());

        System.out.print("Caracteristicas da arma: ");
        leitor.nextLine();// limpa o scanner
        Arma.setNomeArma(leitor.nextLine());

        Armas.add(Arma);

        //leitor.close();
    }

    private void removerArma(){
        Scanner leitor = new Scanner(System.in);
        System.out.print("ID da arma: ");
        int idArma = Integer.parseInt(leitor.next());
        for (int i = 0; i < Armas.size(); i++) {
            Arma Arma = Armas.get(i);
            if (Arma.getIdArma() == idArma){
                Armas.remove(Arma);
                System.out.println("Arma Removida Com Sucesso");
                return;
            }
        }
        System.out.println("Arma nao encontrada");

    }

    private void imprimirArmas(){
        for(Arma Arma : Armas){
            System.out.println("\nId: " + Arma.getIdArma());
            System.out.println("Caracteristicas da Arma: " + Arma.getNomeArma());
            System.out.println("\n\n");
        }
    }

    private void imprimirUltimaArma(){
        Arma arma = Armas.get(Armas.size() -1);
        System.out.println("\nId: " + arma.getIdArma());
        System.out.println("Caracteristicas da Arma: " + arma.getNomeArma());
        System.out.println("\n\n");
    }

    public static void main(String[] args){
        short opcao = 50;
        Scanner leitor = new Scanner(System.in);
        Main Main = new Main();

        do{
            Main.exibirMenu();

            System.out.print("Opção escolhida: ");
            opcao = leitor.nextShort();

            switch(opcao){
                case 1:
                    Main.cadastrarArma();
                    break;
                case 2:
                    Main.removerArma();
                    break;
                case 3:
                    Main.imprimirArmas();
                    break;
                case 4:
                    Main.imprimirUltimaArma();
                    break;
                case 50:
                    Main.exibirMenu();
                    break;
                default:
                    Main.exibirMenu();
            }
        }while(opcao != 99);
    }
}
