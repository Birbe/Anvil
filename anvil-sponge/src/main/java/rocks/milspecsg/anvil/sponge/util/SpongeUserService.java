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

package rocks.milspecsg.anvil.sponge.util;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.service.user.UserStorageService;
import org.spongepowered.api.util.Identifiable;
import rocks.milspecsg.anvil.api.util.UserService;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public class SpongeUserService implements UserService<User, Player> {

    @Override
    public Optional<User> get(String userName) {
        return Sponge.getServiceManager().provide(UserStorageService.class).flatMap(u -> u.get(userName));
    }

    @Override
    public Optional<User> get(UUID userUUID) {
        return Sponge.getServiceManager().provide(UserStorageService.class).flatMap(u -> u.get(userUUID));
    }

    @Override
    public Optional<Player> getPlayer(String userName) {
        return get(userName).flatMap(User::getPlayer);
    }

    @Override
    public Optional<Player> getPlayer(UUID userUUID) {
        return get(userUUID).flatMap(User::getPlayer);
    }

    @Override
    public Collection<Player> getOnlinePlayers() {
        return Sponge.getServer().getOnlinePlayers();
    }

    @Override
    public Optional<UUID> getUUID(String userName) {
        return get(userName).map(Identifiable::getUniqueId);
    }

    @Override
    public Optional<String> getUserName(UUID userUUID) {
        return get(userUUID).map(User::getName);
    }

    @Override
    public UUID getUUID(User user) {
        return user.getUniqueId();
    }

    @Override
    public String getUserName(User user) {
        return user.getName();
    }
}
