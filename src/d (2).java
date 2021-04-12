
public class d {

}
//compare with first character occurences
if(counter == 0)    freq = letterFreqs.get(ch);
else{
    if(letterFreqs.get(ch)!=freq){
        //first chance
        if(allowance == 1){
            if(letterFreqs.get(ch)>freq){
               if(letterFreqs.get(ch)-freq == 1){
                        f = letterFreqs.get(ch);
                        letterFreqs.put(ch,f--);         
                }
                else return "NO";
            }
            else  {
                if(freq-letterFreqs.get(ch) == 1)   freq--;
                //difference is more than 1
                else    return "NO";
            }                          
        }  
        //no left chance
        else    return "NO"; 
    }
}
}
static String isValid(String s) {
    HashMap<Character,Integer> letterFreqs = new HashMap<Character,Integer>(); 
    for(int i = 0 ; i < s.length(); i++){
        if(letterFreqs.containsKey(s.charAt(i))){
            int freq = letterFreqs.get(s.charAt(i));
            freq++;
            letterFreqs.put(s.charAt(i),freq);
        }
        else{
            letterFreqs.put(s.charAt(i),1);
        }
    }
    ArrayList<Integer> list = new ArrayList<Integer>();
    int size = 0;
    for(char ch : letterFreqs.keySet()){
        //load freqs
        if(!list.contains(letterFreqs.get(ch))){
            list.add(letterFreqs.get(ch));
            size++;
        }
    }
    //more than 2 different freq 
    if(size>2)  return "NO";
    //remove in case of 1
    if(list.get(0)==1 || list.get(1)==1)    return "YES";
    //
    if(Math.abs(list.get(0)-list.get(1)) == 1)        return "YES";
    else    return  "NO";   
}