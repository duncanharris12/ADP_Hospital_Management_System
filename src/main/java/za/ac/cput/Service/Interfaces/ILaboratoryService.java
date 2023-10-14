package za.ac.cput.Service.Interfaces;

import za.ac.cput.Entity.Laboratory;
import za.ac.cput.Service.IService;

import java.util.List;
import java.util.Set;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 15 August 2022
 *
 */

public interface ILaboratoryService extends IService<Laboratory, String> {

    public List<Laboratory> getAllLaboratory();


}
