package unit.com.bitdubai.fermat_dmp_plugin.layer.wallet_module.crypto_wallet.developer.bitdubai.version_1.structure.WalletModuleCryptoWallet;

import com.bitdubai.fermat_api.layer.dmp_middleware.wallet_contacts.interfaces.WalletContactsManager;
import com.bitdubai.fermat_api.layer.dmp_middleware.wallet_contacts.interfaces.WalletContactsRegistry;
import com.bitdubai.fermat_api.layer.dmp_wallet_module.crypto_wallet.exceptions.CantDeleteWalletContactException;
import com.bitdubai.fermat_dmp_plugin.layer.wallet_module.crypto_wallet.developer.bitdubai.version_1.structure.WalletModuleCryptoCrypto;
import com.bitdubai.fermat_pip_api.layer.pip_platform_service.error_manager.ErrorManager;
import com.bitdubai.fermat_cry_api.layer.crypto_module.actor_address_book.interfaces.ActorAddressBookManager;
import com.bitdubai.fermat_cry_api.layer.crypto_module.crypto_address_book.interfaces.CryptoAddressBookManager;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static com.googlecode.catchexception.CatchException.*;
import static org.fest.assertions.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class DeleteWalletContactTest extends TestCase {

    /**
     * DealsWithActorAddressBook interface Mocked
     */
    @Mock
    ActorAddressBookManager actorAddressBookManager;

    /**
     * DealsWithErrors interface Mocked
     */
    @Mock
    ErrorManager errorManager;

    /**
     * DealsWithCryptoAddressBook interface Mocked
     */
    @Mock
    CryptoAddressBookManager cryptoAddressBookManager;

    /**
     * DealsWithWalletContacts interface Mocked
     */
    @Mock
    WalletContactsManager walletContactsManager;


    @Mock
    WalletContactsRegistry walletContactsRegistry;

    UUID contactId;

    WalletModuleCryptoCrypto walletModuleCryptoWallet;

    @Before
    public void setUp() throws Exception {
        doReturn(walletContactsRegistry).when(walletContactsManager).getWalletContactsRegistry();
        contactId = UUID.randomUUID();
        walletModuleCryptoWallet = new WalletModuleCryptoCrypto();
        walletModuleCryptoWallet.setActorAddressBookManager(actorAddressBookManager);
        walletModuleCryptoWallet.setErrorManager(errorManager);
        walletModuleCryptoWallet.setCryptoAddressBookManager(cryptoAddressBookManager);
        walletModuleCryptoWallet.setWalletContactsManager(walletContactsManager);
        walletModuleCryptoWallet.initialize();
    }

    @Test
    public void testDeleteWalletContact_Success() throws Exception {
        catchException(walletModuleCryptoWallet).deleteWalletContact(contactId);
        assertThat(caughtException()).isNull();
    }

    @Test(expected=CantDeleteWalletContactException.class)
    public void testDeleteWalletContact_CantUpdateWalletContactException() throws Exception {
        doThrow(new com.bitdubai.fermat_api.layer.dmp_middleware.wallet_contacts.exceptions.CantDeleteWalletContactException())
        .when(walletContactsRegistry).deleteWalletContact(any(UUID.class));

        walletModuleCryptoWallet.deleteWalletContact(contactId);
    }
}
