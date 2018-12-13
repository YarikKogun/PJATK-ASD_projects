import java.io.*;

/**
 * Created by yaroslavkohun on 12/14/17.
 */
class Element {
    static Element actualElement;
    static char[] theOldestWord = new char[65];

    char value;
    Element rightElement;
    Element leftElement;
    Element topElement;

    public Element(){
        this.value = 0;
        this.rightElement = null;
        this.leftElement = null;
        this.topElement = null;
    }

    public void recursion(){
        //if it has left element
        if(this.leftElement!=null){
            this.leftElement.recursion();
        }
        //if it has right elemet
        if(this.rightElement!=null){
            this.rightElement.recursion();
        }
        //if it doesn't have left/right element -> it's leaf
        else if(this.leftElement==null){
            Element.actualElement = this;
            int i = 0;
            while (Element.actualElement.topElement!=null){
                //actual 'theOldestWord' is shorter than actual word
                if(Element.theOldestWord[i]==0){
                    while (Element.actualElement.topElement!=null){
                        Element.theOldestWord[i] = Element.actualElement.value;
                        Element.actualElement = Element.actualElement.topElement;
                        i++;
                    }
                    Element.theOldestWord[i] = Element.actualElement.value;
                    //add null to the end of word
                    Element.theOldestWord[i+1] = 0;
                    break;
                }
                //actual letter 'theOldestWord' is the letter of actual word
                //it may be the oldest -> checking...
                else if(Element.theOldestWord[i] == Element.actualElement.value){
                    Element.actualElement = Element.actualElement.topElement;
                    i++;
                }
                //actual letter 'theOldestWord' is lower, than letter of actual word
                //actual word is the oldest -> put in to the end
                else if(Element.theOldestWord[i] < Element.actualElement.value){
                    while(Element.actualElement.topElement!=null){
                        Element.theOldestWord[i] = Element.actualElement.value;
                        Element.actualElement = Element.actualElement.topElement;
                        i++;
                    }
                    Element.theOldestWord[i] = Element.actualElement.value;
                    //add null to the end of word
                    Element.theOldestWord[i+1] = 0;
                    break;
                }
                else break;

            }
            //add the last element
            if(Element.theOldestWord[i] <= Element.actualElement.value){
                Element.theOldestWord[i] = Element.actualElement.value;
                //add null to the end of word
                Element.theOldestWord[i+1] = 0;
            }
        }
    }

    public static void main(String[] args){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int counter = 0;

        try {
            int inputChar;
            char value = (char)input.read();
            counter++;
            Element topElement = new Element();
            actualElement = topElement;


            while ((inputChar = input.read())!=-1){
                //letter 'a-z'
                if(inputChar > 96 && inputChar < 123){
                    actualElement.value = value;
                    actualElement = topElement;
                    value = (char)inputChar;
                    counter++;
                }
                //R
                else if(inputChar == 82){
                    if(actualElement.rightElement==null){
                        actualElement.rightElement = new Element();
                        actualElement.rightElement.topElement = actualElement;
                    }
                    actualElement = actualElement.rightElement;
                    counter++;
                }
                //L
                else if(inputChar == 76){
                    if(actualElement.leftElement==null){
                        actualElement.leftElement = new Element();
                        actualElement.leftElement.topElement = actualElement;
                    }
                    actualElement = actualElement.leftElement;
                    counter++;
                }
            }
            actualElement.value = value;

            topElement.recursion();
            for (int i = 0; i<theOldestWord.length; i++){
                if(theOldestWord[i] == 0)
                    break;
                System.out.print(theOldestWord[i]);
            }
            System.out.print("\n"+counter);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}