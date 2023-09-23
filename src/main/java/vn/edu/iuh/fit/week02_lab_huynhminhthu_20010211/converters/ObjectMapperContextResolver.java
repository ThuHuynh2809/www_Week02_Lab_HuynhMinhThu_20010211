package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.converters;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;
@Provider
public class ObjectMapperContextResolver implements
        ContextResolver<ObjectMapper> {
    final ObjectMapper mapper = new ObjectMapper();
    public ObjectMapperContextResolver() {
        mapper.registerModule(new JavaTimeModule());
    }
    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }
}
