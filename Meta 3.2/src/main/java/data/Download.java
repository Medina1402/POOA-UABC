package data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author <a href="https://github.com/medina1402" target="_blank">Abraham Medina Carrillo</a>
 */

public class Download {
    /**
     * Comprueba la conexion a internet (utiliza la pagina principal del buscador de GOOGLE)
     * @return El estado de la conexion con internet
     */
    public static boolean ComprobarConexion() {
        try {
            return new Socket("www.google.com", 80).isConnected();
        } catch (IOException e) {
            return false;
        }
    }

    public static ItemList get(String _url) {
        ItemList vector = new ItemList();

        Document doc = null;
        try {
            doc = Jsoup.connect(_url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = doc.select(".cover-art-image").attr("style").split("//")[1].split(",")[0].replace(")", "");
        createImage("https://" + url, "portada.png");
//        System.out.println("Imagen Playlist: " + url  + "\n");
        Elements newsHeadlines = doc.select(".tracklist-row");
//        System.out.println( "https://" + url + " :::: " + doc.select(".TrackListHeader__entity-name").select("h2").text());
        for (int k=0; k<newsHeadlines.size(); k++) {
            Elements nodo = newsHeadlines.get(k).select(".name > .track-name-wrapper");
            vector.add(new Item(nodo.select(".artists-albums").select("span").get(1).text(), nodo.select(".track-name").text(), k+1));
//            System.out.println("Cancion: " + nodo.select(".track-name").text());
//            System.out.println("Artista: " + nodo.select(".artists-albums").select("span").get(1).text());
//            System.out.println("Album: " + nodo.select(".artists-albums").select("span").get(2).text() + "\n");
        }

        return vector;
    }

    public static void createImage(String _url, String name) {
        try {
            // Url con la foto
            URL url = new URL(_url);

            // establecemos conexion
            URLConnection urlCon = url.openConnection();

            // Sacamos por pantalla el tipo de fichero
            System.out.println(urlCon.getContentType());

            // Se obtiene el inputStream de la foto web y se abre el fichero
            InputStream is = urlCon.getInputStream();
            FileOutputStream fos = new FileOutputStream(name);

            // Lectura de la foto de la web y escritura en fichero local
            byte[] array = new byte[1000]; // buffer temporal de lectura.
            int leido = is.read(array);
            while (leido > 0) {
                fos.write(array, 0, leido);
                leido = is.read(array);
            }

            // cierre de conexion y fichero.
            is.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
