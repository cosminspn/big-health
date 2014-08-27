/**
 * 
 */
package ro.bighealth.restloader.test.core;

import org.unitils.UnitilsJUnit4;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.spring.annotation.SpringApplicationContext;

/**
 * Base test class with global annotations.
 * 
 * @author CosminS
 * @since Mar 10, 2014
 */
@SpringApplicationContext(value = "classpath:spring/spring-root.xml")
@Transactional(value = TransactionMode.ROLLBACK)
public abstract class BaseTest extends UnitilsJUnit4 {

}