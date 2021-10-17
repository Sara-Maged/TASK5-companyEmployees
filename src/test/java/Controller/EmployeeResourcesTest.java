package Controller;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;

class EmployeeResourcesTest {

    @Test
    public void getEmployeesByRole()  throws ClientProtocolException, IOException {

        EmployeeResources employeeResources = new EmployeeResources();

        // Given
        String jsonMimeType = "application/json";
        //Mockito.doReturn(jsonMimeType).when(employeeResources).getEmployeesByRole();
        HttpUriRequest request = new HttpGet( "http://localhost:8888/api/employees/getRole" );


        // When
        HttpResponse response = HttpClientBuilder.create().build().execute( request );

        // Then
        String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
        assertEquals( jsonMimeType, mimeType );
    }

    @Test
    void getEmployees()  throws ClientProtocolException, IOException {
        // Given
        String jsonMimeType = "application/json";
        HttpUriRequest request = new HttpGet( "http://localhost:8888/api/employees/get" );

        // When
        HttpResponse response = HttpClientBuilder.create().build().execute( request );

        // Then
        String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
        assertEquals( jsonMimeType, mimeType );
    }

    @Test
    void addEmpToProj() {
    }

    @Test
    void getEmpWithPage() throws ClientProtocolException, IOException{
        // Given
        String jsonMimeType = "text/html";
        HttpUriRequest request = new HttpGet( "http://localhost:8888/api/employees/postpage" );

        // When
        HttpResponse response = HttpClientBuilder.create().build().execute( request );

        // Then
        String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
        assertEquals( jsonMimeType, mimeType );
    }
}