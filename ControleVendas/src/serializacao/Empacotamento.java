package serializacao;

import java.io.File;
import java.io.IOException;
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
  
    } catch(Exception erro) {
        throw new IllegalArgumentException("Erro ao criar arquivo.");
    }
  }
  
  // Desserialização: recuperando os objetos gravados no arquivo binário "nomeArq"
  public static Object lerArquivoBinario(String nomeArq) throws IOException, ClassNotFoundException {
    Object obj = new Object();
    try {
      File arq = new File(nomeArq);
      if (arq.exists()) {
         ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
         obj = (Object)objInput.readObject();
         objInput.close();
      }
    } catch(IOException erro1) {
        throw new IllegalArgumentException("Erro ao ler arquivo.");
    } catch(ClassNotFoundException erro2) {
    	throw new IllegalArgumentException("Erro ao ler arquivo.");
    }
  
    return(obj);
  }
  
}
