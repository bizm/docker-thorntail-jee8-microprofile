package nl.casparderksen.documentservice.application;

import nl.casparderksen.documentservice.domain.Document;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DocumentRepository {

    Optional<Document> findById(UUID id);

    List<Document> findAll();

    List<Document> findRange(int start, int size);

    long count();

    Document update(Document document);

    Document save(Document document);

    void deleteById(UUID id);
}
