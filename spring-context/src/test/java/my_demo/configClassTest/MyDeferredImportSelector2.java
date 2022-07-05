package my_demo.configClassTest;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

@Order(800)
public class MyDeferredImportSelector2 implements DeferredImportSelector {

    @Override
    public Class<? extends Group> getImportGroup() {
        return MyDeferredImportSelectorGroup2.class;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"my_demo.configClassTest.configBean.TestBean6"};
    }

    private static class MyDeferredImportSelectorGroup2 implements Group {

        private final List<Entry> imports = new ArrayList<>();

        //收集需要实例化的类
        @Override
        public void process(AnnotationMetadata metadata, DeferredImportSelector selector) {
            for (String importClassName : selector.selectImports(metadata)) {
                this.imports.add(new Entry(metadata, importClassName));
            }
        }

        //返回要实例化的类
        @Override
        public Iterable<Entry> selectImports() {
            return this.imports;
        }
    }
}