package my_demo.configClassTest;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.Ordered;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

public class TestDeferredImportSelector implements DeferredImportSelector {
    @Override
    public Class<? extends Group> getImportGroup() {
        return MyDeferredImportSelectorGroup.class;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"my_demo.configClassTest.TestBean5"};
    }

    private static class MyDeferredImportSelectorGroup implements Group {

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
