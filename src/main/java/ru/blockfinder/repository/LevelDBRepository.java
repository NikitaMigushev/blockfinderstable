package ru.blockfinder.repository;

import org.cloudburstmc.nbt.NbtMap;
import ru.blockfinder.model.SimpleChunk;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface LevelDBRepository {
    Set<SimpleChunk> getAllChunks() throws IOException;
    Set<SimpleChunk> findChunksWithEntitiesByName(String name) throws IOException;
    Set<String> getUniqueEntities() throws IOException;
    List<NbtMap>  findTagsByName(String name) throws IOException;

}