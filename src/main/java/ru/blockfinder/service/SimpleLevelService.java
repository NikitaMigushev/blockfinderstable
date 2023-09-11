package ru.blockfinder.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.cloudburstmc.nbt.NbtMap;
import ru.blockfinder.model.SimpleChunk;
import ru.blockfinder.repository.LevelDBRepository;
import ru.blockfinder.repository.SimpleLevelDBRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class SimpleLevelService implements LevelService {
    private LevelDBRepository repository;

    public SimpleLevelService() throws IOException {
        this.repository = new SimpleLevelDBRepository();
    }

    @Override
    public Set<SimpleChunk> getAllChunks() throws IOException {
        return repository.getAllChunks();
    }

    @Override
    public Set<SimpleChunk> findChunksWithEntitiesByName(String name) throws IOException {
        return repository.findChunksWithEntitiesByName(name);
    }

    @Override
    public Set<String> getUniqueEntities() throws IOException {
        return repository.getUniqueEntities();
    }

    @Override
    public void createJsonForFindChunksWithEntitiesByName(Set<SimpleChunk> chunks) throws IOException {
        String filePath = "chunks.json";
        try {
            ObjectMapper objectMapper = JsonMapper.builder()
                    .enable(SerializationFeature.INDENT_OUTPUT)
                    .build();
            objectMapper.writeValue(new File(filePath), chunks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<NbtMap> findTagsByName(String name) throws IOException {
        return repository.findTagsByName(name);
    }

    @Override
    public void createJsonForFindTagsByName(List<NbtMap> tags) throws IOException {
        String filePath = "tags.json";
        try {
            ObjectMapper objectMapper = JsonMapper.builder()
                    .enable(SerializationFeature.INDENT_OUTPUT)
                    .build();
            objectMapper.writeValue(new File(filePath), tags);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}