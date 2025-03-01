/*
 * Copyright 2023 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.jmix.flowui.component.delegate;

import com.vaadin.flow.component.AbstractField;
import io.jmix.flowui.component.HasLengthLimited;
import io.jmix.flowui.data.DataAwareComponentsTools;
import io.jmix.flowui.data.EntityValueSource;
import io.jmix.flowui.data.ValueSource;
import io.jmix.flowui.data.binding.impl.AbstractValueBinding;
import io.jmix.flowui.data.binding.impl.FieldValueBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @param <C> component type
 * @param <V> component value type
 */
@Component("flowui_TextAreaFieldDelegate")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TextAreaFieldDelegate<C extends AbstractField<?, String>, V> extends AbstractFieldDelegate<C, V, String> {

    protected DataAwareComponentsTools dataAwareComponentsTools;

    public TextAreaFieldDelegate(C component) {
        super(component);
    }

    @Autowired
    public void setDataAwareComponentsTools(DataAwareComponentsTools dataAwareComponentsTools) {
        this.dataAwareComponentsTools = dataAwareComponentsTools;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected AbstractValueBinding<V> createValueBinding(ValueSource<V> valueSource) {
        return applicationContext.getBean(FieldValueBinding.class, valueSource, component);
    }

    @Override
    protected void setupProperties(EntityValueSource<?, V> valueSource) {
        if (component instanceof HasLengthLimited hasLengthLimitedComponent) {
            dataAwareComponentsTools.setupLength(hasLengthLimitedComponent, valueSource);
        }
    }
}
