package other.templates

fun someContract(
    packageName: String,
    entityName: String
) = """package $packageName

interface ${entityName}Contract {
    interface View
    interface Presenter
}
"""

fun somePresenter(
    packageName: String,
    entityName: String
) = """package $packageName

class ${entityName}Presenter(
        private val view: ${entityName}Contract.View
): ${entityName}Contract.Presenter {
    
}
"""

fun somePresenterTest(
    packageName: String,
    entityName: String
) = """package $packageName

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InOrder
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ${entityName}PresenterTest {

    @Mock
    private lateinit var view: ${entityName}Contract.View

    private lateinit var presenter: ${entityName}Contract.Presenter
    private lateinit var inOrder: InOrder
    
    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
        inOrder = Mockito.inOrder(view)
        presenter = ${entityName}Presenter(view)
    }
    
    @Test
    fun test() {
        
    }
}
"""