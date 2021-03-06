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

package rocks.milspecsg.anvil.common.component;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import rocks.milspecsg.anvil.api.component.Component;

import java.util.Optional;

public interface CommonMongoComponent extends Component<ObjectId, Datastore> {

    @Override
    default ObjectId parseUnsafe(Object object) {
        if (object instanceof ObjectId) {
            return (ObjectId) object;
        } else if (object instanceof Optional<?>) {
            Optional<?> optional = (Optional<?>) object;
            if (optional.isPresent()) return parseUnsafe(optional.get());
            throw new IllegalArgumentException("Error while parsing " + object + ". Optional not present");
        }
        String string = object.toString();
        if (ObjectId.isValid(string)) return new ObjectId(string);
        throw new IllegalArgumentException("Error while parsing " + object + ". Not a valid ObjectId");
    }
}
