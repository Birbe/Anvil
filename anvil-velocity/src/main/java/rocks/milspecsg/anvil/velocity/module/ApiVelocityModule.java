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

package rocks.milspecsg.anvil.velocity.module;

import com.google.inject.TypeLiteral;
import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.proxy.Player;
import net.kyori.text.TextComponent;
import rocks.milspecsg.anvil.api.util.CurrentServerService;
import rocks.milspecsg.anvil.api.util.KickService;
import rocks.milspecsg.anvil.api.util.StringResult;
import rocks.milspecsg.anvil.api.util.UserService;
import rocks.milspecsg.anvil.common.module.ApiCommonModule;
import rocks.milspecsg.anvil.velocity.util.VelocityCurrentServerService;
import rocks.milspecsg.anvil.velocity.util.VelocityKickService;
import rocks.milspecsg.anvil.velocity.util.VelocityStringResult;
import rocks.milspecsg.anvil.velocity.util.VelocityUserService;

public class ApiVelocityModule extends ApiCommonModule {

    @Override
    protected void configure() {
        super.configure();
        bind(CurrentServerService.class).to(VelocityCurrentServerService.class);
        bind(KickService.class).to(VelocityKickService.class);
        bind(new TypeLiteral<StringResult<TextComponent, CommandSource>>() {
        }).to(VelocityStringResult.class);
        bind(new TypeLiteral<UserService<Player, Player>>() {
        }).to(VelocityUserService.class);
    }
}
