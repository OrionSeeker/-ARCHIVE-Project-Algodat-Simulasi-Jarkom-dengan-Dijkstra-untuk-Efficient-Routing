package CompNet;
import java.util.Scanner;

public class Driver {
    public static void main(String args[]){

        Graph graph = new Graph();
        graph.addVertex("PC0", "192.168.8.2", "PC");
        graph.addVertex("PC1", "192.168.8.3", "PC");
        graph.addVertex("PC2", "192.168.8.4", "PC");
        graph.addVertex("PC3", "192.168.9.2", "PC");
        graph.addVertex("PC4", "192.168.9.3", "PC");
        graph.addVertex("PC5", "192.168.17.2", "PC");
        graph.addVertex("PC6", "192.168.17.3", "PC");
        graph.addVertex("Router5", "0", "Router");
        graph.addVertex("Router6", "0", "Router");
        graph.addVertex("Router0", "0", "Router");
        graph.addVertex("Switch0", "0", "Switch");
        graph.addVertex("Switch1", "0", "Switch");
        graph.addVertex("Switch2", "0", "Switch");
        graph.addVertex("Router4", "0", "Router");
        graph.addVertex("Switch3", "0", "Switch");
        graph.addVertex("PC7", "192.168.10.2", "PC");
        graph.addVertex("PC8", "192.168.10.3","PC");
        graph.addVertex("Router3", "0", "Router");
        graph.addVertex("Switch4", "0", "Switch");
        graph.addVertex("PC9", "192.168.11.2", "PC");
        graph.addVertex("PC10","192.168.11.3", "PC");
        graph.addVertex("Router2", "0", "Router");
        graph.addVertex("Router8", "0", "Router");
        graph.addVertex("Router7", "0", "Router");
        graph.addVertex("Switch5", "0", "Switch");
        graph.addVertex("PC11","192.168.14.2","PC");
        graph.addVertex("PC12", "192.168.14.3", "PC");
        graph.addVertex("Switch7", "0", "Switch");
        graph.addVertex("PC13", "192.168.15.2", "PC");
        graph.addVertex("PC14", "192.168.15.3", "PC");
        graph.addVertex("Switch6", "0", "Switch");
        graph.addVertex("PC15", "192.168.18.2", "PC");
        graph.addVertex("PC16", "192.168.18.3", "PC");
        graph.addVertex("Router1", "0", "Router");
        graph.addVertex("Switch8", "0", "Switch");
        graph.addVertex("PC17", "192.168.16.2", "PC");
        graph.addVertex("PC18", "192.168.16.3", "PC");
        graph.addVertex("PC19", "192.168.16.4", "PC");
        graph.addVertex("PC20", "192.168.16.5", "PC");

        graph.addEdge("PC0", "Switch0", 2);
        graph.addEdge("PC1", "Switch0", 4);
        graph.addEdge("PC2", "Switch0", 1);
        graph.addEdge("PC3", "Switch1", 5);
        graph.addEdge("PC4", "Switch1", 2);
        graph.addEdge("PC5", "Switch2", 4);
        graph.addEdge("PC6", "Switch2", 6);
        graph.addEdge("Router5", "Switch0", 7);
        graph.addEdge("Router6", "Switch1", 13);
        graph.addEdge("Router6", "Switch2", 3);
        graph.addEdge("Router5", "Router0", 12);
        graph.addEdge("Router6", "Router0", 10);
        graph.addEdge("Router0", "Router4", 20);
        graph.addEdge("Router4", "Switch3", 7);
        graph.addEdge("Switch3", "PC7", 3);
        graph.addEdge("Switch3", "PC8", 2);
        graph.addEdge("Router4", "Router3", 15);
        graph.addEdge("Router3", "Switch4", 5);
        graph.addEdge("Switch4", "PC9", 3);
        graph.addEdge("Switch4", "PC10", 4);
        graph.addEdge("Router3", "Router2", 15);
        graph.addEdge("Router2", "Router8", 7);
        graph.addEdge("Router8", "Switch5", 2);
        graph.addEdge("Switch5", "PC11", 3);
        graph.addEdge("Switch5", "PC12", 1);
        graph.addEdge("Router2", "Router7", 12);
        graph.addEdge("Router7", "Switch7", 8);
        graph.addEdge("Switch7", "PC13", 2);
        graph.addEdge("Switch7", "PC14", 6);
        graph.addEdge("Switch6", "Router7", 4);
        graph.addEdge("Switch6", "PC16", 3);
        graph.addEdge("Switch6", "PC15", 8);
        graph.addEdge("Router2", "Router1", 8);
        graph.addEdge("Router1", "Switch8", 1);
        graph.addEdge("Switch8", "PC17", 6);
        graph.addEdge("Switch8", "PC18", 4);
        graph.addEdge("Switch8", "PC19", 2);
        graph.addEdge("Switch8", "PC20", 8);
        graph.addEdge("Router1", "Router0", 12);

        Scanner scanner = new Scanner(System.in);
        int pil;

        do{
            System.out.println("=====Simulasi Jaringan Komputer=====");
            System.out.println("1. Melakukan Ping by IP");
            System.out.println("2. Melakukan Ping by nama perangkat");
            System.out.println("3. Melihat daftar perangkat");
            System.out.println("4. Menambah perangkat dan jalur routing baru");
            System.out.println("5. Menambah jalur routing baru");
            System.out.println("6. Keluar");

            System.out.print("Input (1/2/3/4/5/6): ");
            pil = scanner.nextInt();

            switch(pil){
                case 1:
                    System.out.println("Melakukan Ping by IP");
                    System.out.println("Daftar perangkat: ");
                    graph.dfs("PC0");
                    System.out.print("Masukkan IP pengirim: ");
                    scanner.nextLine();
                    String ip = scanner.nextLine();
                    System.out.print("Masukkan IP penerima: ");
                    String ip2 = scanner.nextLine();
                    graph.routingbyIP(ip,ip2);
                    pressEnterKey();
                    break;
                case 2:
                    System.out.println("Melakukan Ping by nama perangkat");
                    System.out.println("Daftar perangkat: ");
                    graph.dfs("PC0");
                    System.out.print("Masukkan nama perangkat pengirim: ");
                    scanner.nextLine();
                    String pc = scanner.nextLine();
                    System.out.print("Masukkan nama perangkat penerima: ");
                    String pc2 = scanner.nextLine();
                    graph.routingbyNama(pc,pc2);
                    pressEnterKey();
                    break;
                case 3:
                    System.out.println("Melihat daftar perangkat");
                    System.out.println("Berikut ini daftar perangkat yang diurutkan berdasarkan namanya secara Ascending: ");
                    graph.dfs("PC0");
                    pressEnterKey();
                    break;
                case 4:
                    System.out.println("Menambah perangkat dan jalur routing baru");
                    System.out.println("Daftar perangkat: ");
                    graph.dfs("PC0");
                    System.out.print("Masukkan jenis perangkat: ");
                    scanner.nextLine();
                    String jnsPerangkat = scanner.nextLine();
                    String nmPerangkat;
                    do{
                        System.out.print("Masukkan nama perangkat: ");
                        nmPerangkat = scanner.nextLine();
                        if(graph.cekDuplikatNama(nmPerangkat)){
                            System.out.println("Nama perangkat sudah ada, silahkan isi yang lain");
                        }
                    }while(graph.cekDuplikatNama(nmPerangkat));
                    String ipPerangkat;
                    if(jnsPerangkat.equals("Router") || jnsPerangkat.equals("Switch")){
                        ipPerangkat = "0";
                    }
                    else{
                        do{
                            System.out.print("Masukkan IP perangkat: ");
                            ipPerangkat = scanner.nextLine();
                            if(graph.cekDuplikatIP(ipPerangkat)){
                                System.out.println("IP perangkat sudah ada, silahkan isi yang lain");
                            }
                        }while(graph.cekDuplikatIP(ipPerangkat));
                    }
                    graph.addVertex(nmPerangkat,ipPerangkat,jnsPerangkat);
                    String nmPerangkat2;
                    do{
                        System.out.print("Masukkan nama perangkat tujuan: ");
                        nmPerangkat2 = scanner.nextLine();
                        if(graph.cekDuplikatEdge(nmPerangkat, nmPerangkat2)){
                            System.out.println("Rute sudah ada, silahkan isi yang lain");
                        }
                        if(!graph.cekDuplikatNama(nmPerangkat2)){
                            System.out.println("Vertex tujuan tidak ada, silahkan isi yang lain");
                        }
                    }while(graph.cekDuplikatEdge(nmPerangkat, nmPerangkat2) || !graph.cekDuplikatNama(nmPerangkat2));
                    System.out.print("Masukkan jarak ke perangkat tujuan: ");
                    int jarakRouting = scanner.nextInt();
                    graph.addEdge(nmPerangkat, nmPerangkat2, jarakRouting);
                    pressEnterKey();
                    break;
                case 5:
                    System.out.println("Menambah jalur routing baru");
                    System.out.println("Daftar perangkat: ");
                    graph.dfs("PC0");
                    String nPerangkat;
                    String nPerangkat2;
                    do{
                        do{
                            scanner.nextLine();
                            System.out.print("Masukkan nama perangkat asal: ");
                            nPerangkat = scanner.nextLine();
                            if(!graph.cekDuplikatNama(nPerangkat)){
                                System.out.println("Vertex asal tidak ada, silahkan isi yang lain");
                            }
                        }while(!graph.cekDuplikatNama(nPerangkat));
                        System.out.print("Masukkan nama perangkat tujuan: ");
                        nPerangkat2 = scanner.nextLine();
                        if(graph.cekDuplikatEdge(nPerangkat, nPerangkat2)){
                            System.out.println("Rute sudah ada, silahkan isi yang lain");
                        }
                        if(!graph.cekDuplikatNama(nPerangkat2)){
                            System.out.println("Vertex tujuan tidak ada, silahkan isi yang lain");
                        }
                    }while(graph.cekDuplikatEdge(nPerangkat, nPerangkat2) || !graph.cekDuplikatNama(nPerangkat2));
                    System.out.print("Masukkan jarak ke perangkat tujuan: ");
                    int nJarak = scanner.nextInt();
                    graph.addEdge(nPerangkat, nPerangkat2, nJarak);
                    pressEnterKey();
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan program ini");
                    break;
                default:
                    System.out.println("Silahkan pilih 1/2/3/4/5/6");
                    break;
            }
        }while(pil!=6);
        scanner.close();
    }

    public static void pressEnterKey(){
        System.out.println("Tekan enter untuk melanjutkan");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
