package LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private final String album;
    private final String artista;
    private ArrayList<Cancion> canciones;

    public Album(String album, String artista) {
        this.album = album;
        this.artista = artista;
        this.canciones=new ArrayList<>();
    }

    public String getAlbum() {
        return album;
    }
    public String getArtista() {
        return artista;
    }
    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public Cancion encontrarCancion(String titulo){
        for(Cancion cancion:canciones){
            if(cancion.getTitulo().equals(titulo)){
                return cancion;
            }
        }
        return null;
    }

    public boolean addCancion(String titulo, double duracion){
        if(encontrarCancion(titulo)==null){
            Cancion cancion=new Cancion(titulo,duracion);

        canciones.add(cancion);
        return true;
        }
        return false;
    }

    public boolean addToPlayList(int noPista, LinkedList<Cancion> playList){
        if(noPista >= 1 && noPista <= canciones.size()){
            playList.add(canciones.get(noPista-1));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String titulo, LinkedList<Cancion> playList){
        if(canciones!=null){
            for(Cancion cancion:canciones){
                if(cancion.getTitulo().equalsIgnoreCase(titulo)){
                    playList.add(cancion);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
      StringBuilder album = new StringBuilder("Album "+this.getAlbum()+" de "+this.getArtista()+"\n");
      for(int i=0;i<canciones.size();i++){
          album.append(i+". "+canciones.get(i).toString()+"\n");
      }
      return album.toString();
    }

}
