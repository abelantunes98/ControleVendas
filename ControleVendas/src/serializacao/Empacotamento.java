package serializacao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
  
public class Empacotamento {
  
  // serialização: gravando o objetos no arquivo binário "nomeArq"
  public static void gravarArquivoBinario(Object obj, String nomeArq) {
    File arq = new File(nomeArq);
    try {
      arq.delete();
      arq.createNewFile();
  
      ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
      objOutput.writeObject(obj);
      objOutput.close();
  
    } catch(IOException erro) {
        System.out.printf("Erro: %s", erro.getMessage());
    }
  }
  
  // desserialização: recuperando os objetos gravados no arquivo binário "nomeArq"
  public static Object lerArquivoBinario(String nomeArq) {
    Object obj = new Object();
    try {
      File arq = new File(nomeArq);
      if (arq.exists()) {
         ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
         obj = (Object)objInput.readObject();
         objInput.close();
      }
    } catch(IOException erro1) {
        System.out.printf("Erro: %s", erro1.getMessage());
    } catch(ClassNotFoundException erro2) {
        System.out.printf("Erro: %s", erro2.getMessage());
    }
  
    return(obj);
  }
  
}
