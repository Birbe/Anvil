/*
 *     MSRepository - MilSpecSG
 *     Copyright (C) 2019 Cableguy20
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

package rocks.milspecsg.msrepository.api.component;

import rocks.milspecsg.msrepository.api.manager.Manager;
import rocks.milspecsg.msrepository.api.repository.Repository;
import rocks.milspecsg.msrepository.api.cache.RepositoryCacheService;
import rocks.milspecsg.msrepository.BindingExtensions;
import rocks.milspecsg.msrepository.datastore.DataStoreConfig;
import rocks.milspecsg.msrepository.datastore.DataStoreContext;

/**
 * Part of a module
 *
 * @see Manager
 * @see Repository
 * @see RepositoryCacheService
 * @see BindingExtensions
 */
public interface Component<
    TKey,
    TDataStore,
    TDataStoreConfig extends DataStoreConfig> {

    Class<TKey> getTKeyClass();

    DataStoreContext<TKey, TDataStore, TDataStoreConfig> getDataStoreContext();

}