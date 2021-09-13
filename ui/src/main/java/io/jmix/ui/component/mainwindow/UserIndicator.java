/*
 * Copyright 2019 Haulmont.
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

package io.jmix.ui.component.mainwindow;

import io.jmix.ui.component.ComboBox;
import io.jmix.ui.component.Component;
import io.jmix.ui.component.HasFormatter;
import io.jmix.ui.component.Label;
import io.jmix.ui.component.mainwindow.impl.SubstituteUserAction;
import io.jmix.ui.meta.CanvasBehaviour;
import io.jmix.ui.meta.StudioComponent;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
@StudioComponent(
        caption = "UserIndicator",
        category = "Main window",
        xmlElement = "userIndicator",
        icon = "io/jmix/ui/icon/mainwindow/userIndicator.svg",
        canvasBehaviour = CanvasBehaviour.LABEL,
        canvasTextProperty = "id",
        canvasText = "User",
        unsupportedProperties = {"css", "caption", "captionAsHtml", "description", "descriptionAsHtml", "responsive"}
)
public interface UserIndicator extends Component.BelongToFrame, HasFormatter<UserDetails> {

    String NAME = "userIndicator";

    /**
     * Informs this component that the current user may be changed and refresh is needed.
     */
    void refreshUser();

    /**
     * Allows to set additional users that can be substituted.
     * <br>
     * {@link ComboBox} will be created instead of {@link Label} if {@code additionalUsers} is not empty.
     * <br>
     * <b> {@link UserIndicator#refreshUser()} must be invoked after this method to apply changes</b>,
     */
    void setAdditionalUsers(Collection<UserDetails> additionalUsers);

    /**
     * Allows to set callback that performs user substitution. Substituted user will be passed as parameter
     * <br>
     * <b> {@link UserIndicator#refreshUser()} must be invoked after this method to apply changes</b>,
     *
     * @param step
     */
    void addSubstituteStep(SubstituteUserAction.SubstituteStep step);

}
