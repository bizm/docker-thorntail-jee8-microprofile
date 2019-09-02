package nl.casparderksen.application.adapter.rest;

import lombok.NoArgsConstructor;
import nl.casparderksen.application.domain.ApplicationInfo;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

@ApplicationScoped
@Path("/info")
@Tag(name = "Info service", description = "Provides application info")
public class ApplicationInfoResource {

    @Inject
    private Config config;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Operation(description = "Gets application info")
    @APIResponse(responseCode = "200", description = "Success, info returned")
    public ApplicationInfo getInfo() {
        return new ApplicationInfoDTO(config);
    }

    @NoArgsConstructor
    @XmlRootElement(name = "info")
    private static class ApplicationInfoDTO extends ApplicationInfo {
        ApplicationInfoDTO(Config config) {
            super((config));
        }
    }
}
