package co.owa.streamdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Configurator {
	
    private boolean stopLoop = false;
    private InputStream inputStream;
    private BufferedReader bufferedReader;
    
    Configurator(InputStream _inputStream) {
    	if(_inputStream == null) {
            throw new IllegalArgumentException("null inputStream");
        }
        this.inputStream = _inputStream;
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

    }
	
	public static void main(String[] args) {
		
		Configurator config = new Configurator(System.in);
		
		 while (!config.stopLoop) {
			 String userInput = null;
			 try {
	        	 userInput = config.readUserInput();
	        	 System.out.println(userInput);
	         } catch (IOException e) {
	        	 e.printStackTrace();
	         }
	         if(userInput == null) {
	        	 config.stopLoop = true;
	             break;
	         }
	        
	        }
		
	}
	
	private String readUserInput() throws IOException {
        return bufferedReader.readLine();
    }


}
