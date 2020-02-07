/*
 *   Anvil - MilSpecSG
 *   Copyright (C) 2020 Cableguy20
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package rocks.milspecsg.anvil.core.sponge.module;

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.text.Text;
import rocks.milspecsg.anvil.core.common.data.config.AnvilCoreConfigurationService;
import rocks.milspecsg.anvil.core.common.module.CommonModule;
import rocks.milspecsg.anvil.core.sponge.data.config.AnvilCoreSpongeConfigurationService;

public class SpongeModule extends CommonModule<Text, CommandSource> {

    @Override
    protected void configure() {
        super.configure();

        bind(AnvilCoreConfigurationService.class).to(AnvilCoreSpongeConfigurationService.class);
    }
}