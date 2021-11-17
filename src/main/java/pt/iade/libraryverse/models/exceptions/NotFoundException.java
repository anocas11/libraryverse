package pt.iade.libraryverse.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException
{
       
    public NotFoundException(String elemType, String idName, String id)
    {
        super(elemType+" with " + idName + "" + id + "not found.");
    }
}