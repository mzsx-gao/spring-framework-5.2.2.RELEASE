package my_demo.baseioc.converter;

import org.springframework.core.convert.converter.Converter;

public class StringToObjectConverter implements Converter<String, StringObject> {

    @Override
    public StringObject convert(String source) {
        System.out.println("==============StringToObjectConverter");
        StringObject record = new StringObject();
        record.setName(source);
        return record;
    }

}
