package org.example;
import org.voltdb.VoltTable;
import org.voltdb.client.Client;
import org.voltdb.client.ClientConfig;
import org.voltdb.client.ClientFactory;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try {
            // VoltDB bağlantı yapılandırması
            ClientConfig config = new ClientConfig("HaticeSudenas","Tehas2001."); // İsteğe bağlı bir istemci adı belirleyebilirsiniz
            config.setTopologyChangeAware(true); // Sunucu topolojisi değişikliklerine duyarlılık (isteğe bağlı)

            // VoltDB bağlantısını oluşturma
            Client client = ClientFactory.createClient(config);
            client.createConnection("0.0.0.0",21212); // VoltDB sunucusunun adresini buraya yazınız
            System.out.println("VoltDB bağlantısı başarıyla oluşturuldu.");

            
            // ...
            String query = "SELECT * FROM SUBSCRIBER;";
            VoltTable[] results = client.callProcedure("@AdHoc", query).getResults();
            for (VoltTable result : results) {
                while (result.advanceRow()) {
                    System.out.println(result.toString());

                }
            }

            // Bağlantıyı kapatma
            client.close();
            System.out.println("VoltDB bağlantısı kapatıldı.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
