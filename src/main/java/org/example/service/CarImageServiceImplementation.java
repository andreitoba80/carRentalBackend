package org.example.service;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CarImageServiceImplementation implements CarImageService {
    @Override
    public String addImage(MultipartFile file) throws IOException {
        String connectionString = "DefaultEndpointsProtocol=https;AccountName=carrentalback;AccountKey=4RrEEDTHDhQivdWlj6np8wVP3ZQk97nyxn+Gw2HlwEIec4vL/S3rsWpJmt4PlSOWXaQtwy65S86y+AStp4QTBA==;EndpointSuffix=core.windows.net";
        var container = new BlobContainerClientBuilder()
                .connectionString(connectionString)
                .containerName("carimages")
                .buildClient();

        var fileUUID = UUID.randomUUID();
        BlobClient blobClient = container.getBlobClient(fileUUID.toString());
        blobClient.upload(file.getInputStream(), file.getSize(), true);
        return blobClient.getBlobUrl();
    }
}
