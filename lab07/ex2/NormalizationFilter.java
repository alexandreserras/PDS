package lab07.ex2;

import java.text.Normalizer;

public class NormalizationFilter extends Text_abstract{
    NormalizationFilter(Text_interface textReader) {super(textReader);}

    @Override
    public String next(){
        String ret = Normalizer.normalize(super.next(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""); //.replaceAll("[^\\p{ASCII}]", ""
        ret=ret.replaceAll("\\p{Punct}", "");
        return ret;
    }



}
