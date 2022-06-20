class Solution {
    public int minimumLengthEncoding(String[] words) {

    Arrays.sort(words,new Comparator<>()
    {
       public int compare(String a,String b)
       {
           return b.length()-a.length();
       }
    });
    String str="";
    str+=words[0]+"#";
    for(int i=1;i<words.length;i++)
    {
     if(!str.contains(words[i]+"#"))
            str+=words[i]+"#";
    }
    return str.length();
}
}