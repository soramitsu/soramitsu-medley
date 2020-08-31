package contract;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.16.
 */
@SuppressWarnings("rawtypes")
public class Vault extends Contract {
    public static final String BINARY = "6080604052600060078190556009819055600a819055600c805460ff19908116909155600d91909155600e805490911690553480156200003e57600080fd5b5060405162001f7a38038062001f7a833981810160405260c08110156200006457600080fd5b5080516020808301516040808501516060860151608087015160a090970151600180546001600160a01b0319908116331791829055600280546001600160a01b03808c1691909316179055855163077701eb60e41b8152955198999698949793969592949116926377701eb09260048082019391829003018186803b158015620000ed57600080fd5b505afa15801562000102573d6000803e3d6000fd5b505050506040513d60208110156200011957600080fd5b5051600380546001600160a01b0319166001600160a01b039283161790556001546040805163642c9e8960e11b81529051919092169163c8593d12916004808301926020929190829003018186803b1580156200017557600080fd5b505afa1580156200018a573d6000803e3d6000fd5b505050506040513d6020811015620001a157600080fd5b5051600480546001600160a01b03199081166001600160a01b039384161782556005805490911687841617905560068590556007849055600e8054610100600160a81b0319166101008585168102919091179182905560408051632abf68dd60e11b81529051919092049093169263557ed1ba92828101926020929190829003018186803b1580156200023357600080fd5b505afa15801562000248573d6000803e3d6000fd5b505050506040513d60208110156200025f57600080fd5b5051600b556200026f856200027b565b50505050505062000286565b600880549091019055565b611ce480620002966000396000f3fe608060405234801561001057600080fd5b50600436106100a95760003560e01c806359a87bc11161007157806359a87bc11461011457806398d5fdca14610146578063a69bdf161461014e578063c5ebeaec14610156578063f7376f0c14610173578063f78be85a1461017b576100a9565b80631865c57d146100ae578063243582ff146100b85780632da25de3146100d557806343d726d6146100dd578063486501c5146100e5575b600080fd5b6100b6610183565b005b6100b6600480360360208110156100ce57600080fd5b5035610185565b6100b661044b565b6100b6610495565b610102600480360360208110156100fb57600080fd5b503561087a565b60408051918252519081900360200190f35b6100b66004803603606081101561012a57600080fd5b50803590602081013590604001356001600160a01b03166108e7565b610102610b6d565b610102610bf8565b6100b66004803603602081101561016c57600080fd5b5035610c4c565b610102610e4c565b610102610fb6565b565b600e5460ff16156101cf576040805162461bcd60e51b815260206004820152600f60248201526e15985d5b1d081a5cc818db1bdcd959608a1b604482015290519081900360640190fd5b600354604080516323b872dd60e01b81523360048201523060248201526044810184905290516001600160a01b03909216916323b872dd916064808201926020929091908290030181600087803b15801561022957600080fd5b505af115801561023d573d6000803e3d6000fd5b505050506040513d602081101561025357600080fd5b50516102a6576040805162461bcd60e51b815260206004820152601b60248201527f5661756c743a2063616e6e6f74207472616e73666572204541552e0000000000604482015290519081900360640190fd5b61032b600182600e60019054906101000a90046001600160a01b03166001600160a01b031663557ed1ba6040518163ffffffff1660e01b815260040160206040518083038186803b1580156102fa57600080fd5b505afa15801561030e573d6000803e3d6000fd5b505050506040513d602081101561032457600080fd5b50516110a3565b600e60019054906101000a90046001600160a01b03166001600160a01b031663557ed1ba6040518163ffffffff1660e01b815260040160206040518083038186803b15801561037957600080fd5b505afa15801561038d573d6000803e3d6000fd5b505050506040513d60208110156103a357600080fd5b5051600b5560006103b3826110a8565b905060006009548211156103d5575060098054600090915590819003906103e1565b50600980548290039055805b60035460408051630852cd8d60e31b81526004810184905290516001600160a01b03909216916342966c689160248082019260009290919082900301818387803b15801561042e57600080fd5b505af1158015610442573d6000803e3d6000fd5b50505050505050565b600e5460ff1615610183576040805162461bcd60e51b815260206004820152600f60248201526e15985d5b1d081a5cc818db1bdcd959608a1b604482015290519081900360640190fd5b6002546001600160a01b031633146104ac57600080fd5b61052e600e60019054906101000a90046001600160a01b03166001600160a01b031663557ed1ba6040518163ffffffff1660e01b815260040160206040518083038186803b1580156104fd57600080fd5b505afa158015610511573d6000803e3d6000fd5b505050506040513d602081101561052757600080fd5b505161087a565b1561056a5760405162461bcd60e51b8152600401808060200182810382526037815260200180611b816037913960400191505060405180910390fd5b600554600254604080516370a0823160e01b815230600482015290516001600160a01b039384169363a9059cbb93169184916370a0823191602480820192602092909190829003018186803b1580156105c257600080fd5b505afa1580156105d6573d6000803e3d6000fd5b505050506040513d60208110156105ec57600080fd5b5051604080516001600160e01b031960e086901b1681526001600160a01b03909316600484015260248301919091525160448083019260209291908290030181600087803b15801561063d57600080fd5b505af1158015610651573d6000803e3d6000fd5b505050506040513d602081101561066757600080fd5b505060048054600254604080516370a0823160e01b81523094810194909452516001600160a01b039283169363a9059cbb939092169184916370a0823191602480820192602092909190829003018186803b1580156106c557600080fd5b505afa1580156106d9573d6000803e3d6000fd5b505050506040513d60208110156106ef57600080fd5b5051604080516001600160e01b031960e086901b1681526001600160a01b03909316600484015260248301919091525160448083019260209291908290030181600087803b15801561074057600080fd5b505af1158015610754573d6000803e3d6000fd5b505050506040513d602081101561076a57600080fd5b5050600354600254604080516370a0823160e01b815230600482015290516001600160a01b039384169363a9059cbb93169184916370a0823191602480820192602092909190829003018186803b1580156107c457600080fd5b505afa1580156107d8573d6000803e3d6000fd5b505050506040513d60208110156107ee57600080fd5b5051604080516001600160e01b031960e086901b1681526001600160a01b03909316600484015260248301919091525160448083019260209291908290030181600087803b15801561083f57600080fd5b505af1158015610853573d6000803e3d6000fd5b505050506040513d602081101561086957600080fd5b5050600e805460ff19166001179055565b600e5460009060ff16156108c7576040805162461bcd60e51b815260206004820152600f60248201526e15985d5b1d081a5cc818db1bdcd959608a1b604482015290519081900360640190fd5b6108d0826116ce565b506009549091506108e190826117d7565b92915050565b600e5460ff1615610931576040805162461bcd60e51b815260206004820152600f60248201526e15985d5b1d081a5cc818db1bdcd959608a1b604482015290519081900360640190fd5b600554604080516370a0823160e01b815230600482015290516001600160a01b03909216916370a0823191602480820192602092909190829003018186803b15801561097c57600080fd5b505afa158015610990573d6000803e3d6000fd5b505050506040513d60208110156109a657600080fd5b50518311156109e65760405162461bcd60e51b8152600401808060200182810382526027815260200180611c886027913960400191505060405180910390fd5b60006109f0610b6d565b905082811115610a47576040805162461bcd60e51b815260206004820152601b60248201527f5661756c743a3a62757928293a20507269636520746f6f206c6f770000000000604482015290519081900360640190fd5b838102610a5381610185565b6005546040805163a9059cbb60e01b81526001600160a01b038681166004830152602482018990529151919092169163a9059cbb9160448083019260209291908290030181600087803b158015610aa957600080fd5b505af1158015610abd573d6000803e3d6000fd5b505050506040513d6020811015610ad357600080fd5b5051610b26576040805162461bcd60e51b815260206004820181905260248201527f5661756c743a3a6275793a2063616e6e6f74207472616e73666572204541552e604482015290519081900360640190fd5b6040805186815290516001600160a01b0385169184917f9d995b79e708615dc7201d66ebdcb94d773fe76aac960305383a8b4f8dda9f059181900360200190a35050505050565b6000610bf1600e60019054906101000a90046001600160a01b03166001600160a01b031663557ed1ba6040518163ffffffff1660e01b815260040160206040518083038186803b158015610bc057600080fd5b505afa158015610bd4573d6000803e3d6000fd5b505050506040513d6020811015610bea57600080fd5b50516116ce565b9150505b90565b600e5460009060ff1615610c45576040805162461bcd60e51b815260206004820152600f60248201526e15985d5b1d081a5cc818db1bdcd959608a1b604482015290519081900360640190fd5b5060095490565b600e5460ff1615610c96576040805162461bcd60e51b815260206004820152600f60248201526e15985d5b1d081a5cc818db1bdcd959608a1b604482015290519081900360640190fd5b6002546001600160a01b03163314610ced576040805162461bcd60e51b81526020600482015260156024820152744f6e6c79206f776e65722063616e20626f72726f7760581b604482015290519081900360640190fd5b610cf5610fb6565b811115610d49576040805162461bcd60e51b815260206004820152601a60248201527f437265646974206c696d69742069732065786861757374656420000000000000604482015290519081900360640190fd5b6001546002546040805163f97c6e1160e01b81526001600160a01b039283166004820152602481018590529051919092169163f97c6e1191604480830192600092919082900301818387803b158015610da157600080fd5b505af1158015610db5573d6000803e3d6000fd5b505060098054840190555050600e5460408051632abf68dd60e11b815290516101009092046001600160a01b03169163557ed1ba91600480820192602092909190829003018186803b158015610e0a57600080fd5b505afa158015610e1e573d6000803e3d6000fd5b505050506040513d6020811015610e3457600080fd5b5051600b819055610e499060029083906110a3565b50565b6001546040805163634c50ed60e11b815290516000926001600160a01b03169163c698a1da916004808301926020929190829003018186803b158015610e9157600080fd5b505afa158015610ea5573d6000803e3d6000fd5b505050506040513d6020811015610ebb57600080fd5b50516001546040805163642c9e8960e11b815290516001600160a01b0393841693633ddac95393169163c8593d12916004808301926020929190829003018186803b158015610f0957600080fd5b505afa158015610f1d573d6000803e3d6000fd5b505050506040513d6020811015610f3357600080fd5b5051600854604080516001600160e01b031960e086901b1681526001600160a01b0390931660048401526024830191909152516044808301926020929190829003018186803b158015610f8557600080fd5b505afa158015610f99573d6000803e3d6000fd5b505050506040513d6020811015610faf57600080fd5b5051905090565b600e5460009060ff1615611003576040805162461bcd60e51b815260206004820152600f60248201526e15985d5b1d081a5cc818db1bdcd959608a1b604482015290519081900360640190fd5b6000611056600e60019054906101000a90046001600160a01b03166001600160a01b031663557ed1ba6040518163ffffffff1660e01b815260040160206040518083038186803b1580156104fd57600080fd5b9050600061107c600461107660075460065461183890919063ffffffff16565b90611891565b905081811161109057600092505050610bf5565b61109a81836118d3565b92505050610bf5565b505050565b6000806110fc600e60019054906101000a90046001600160a01b03166001600160a01b031663557ed1ba6040518163ffffffff1660e01b815260040160206040518083038186803b158015610bc057600080fd5b50839250905060008183111561111d57506000600a55908190039080611128565b50818103600a556000915b6000611135826002611891565b90506000611243600a6110766009600160009054906101000a90046001600160a01b03166001600160a01b031663c698a1da6040518163ffffffff1660e01b815260040160206040518083038186803b15801561119157600080fd5b505afa1580156111a5573d6000803e3d6000fd5b505050506040513d60208110156111bb57600080fd5b505160035460408051633ddac95360e01b81526001600160a01b039283166004820152602481018a905290519190921691633ddac953916044808301926020929190829003018186803b15801561121157600080fd5b505afa158015611225573d6000803e3d6000fd5b505050506040513d602081101561123b57600080fd5b505190611838565b604080516002808252606080830184529394509091602083019080368337505060035482519293506001600160a01b03169183915060009061128157fe5b6001600160a01b0392831660209182029290920101526004548251911690829060019081106112ac57fe5b60200260200101906001600160a01b031690816001600160a01b0316815250506000600e60019054906101000a90046001600160a01b03166001600160a01b031663557ed1ba6040518163ffffffff1660e01b815260040160206040518083038186803b15801561131c57600080fd5b505afa158015611330573d6000803e3d6000fd5b505050506040513d602081101561134657600080fd5b505160015460408051633349af8760e21b8152905161271090930193506060926001600160a01b039092169163cd26be1c91600480820192602092909190829003018186803b15801561139857600080fd5b505afa1580156113ac573d6000803e3d6000fd5b505050506040513d60208110156113c257600080fd5b50516040516338ed173960e01b8152600481018781526024820187905230606483018190526084830186905260a060448401908152875160a485015287516001600160a01b03909516946338ed1739948b948b948b9490938b9360c401906020878101910280838360005b8381101561144557818101518382015260200161142d565b505050509050019650505050505050600060405180830381600087803b15801561146e57600080fd5b505af1158015611482573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f1916820160405260208110156114ab57600080fd5b81019080805160405193929190846401000000008211156114cb57600080fd5b9083019060208201858111156114e057600080fd5b82518660208202830111640100000000821117156114fd57600080fd5b82525081516020918201928201910280838360005b8381101561152a578181015183820152602001611512565b50505050905001604052505050905060008160018151811061154857fe5b602002602001015190508160008151811061155f57fe5b602002602001015186146115a45760405162461bcd60e51b8152600401808060200182810382526039815260200180611c4f6039913960400191505060405180910390fd5b808510156115e35760405162461bcd60e51b8152600401808060200182810382526032815260200180611c1d6032913960400191505060405180910390fd5b6004805460408051630852cd8d60e31b8152928301849052516001600160a01b03909116916342966c6891602480830192600092919082900301818387803b15801561162e57600080fd5b505af1158015611642573d6000803e3d6000fd5b5050600354604080516391c05b0b60e01b81528a8c03600482015290516001600160a01b0390921693506391c05b0b92506024808201926020929091908290030181600087803b15801561169557600080fd5b505af11580156116a9573d6000803e3d6000fd5b505050506040513d60208110156116bf57600080fd5b50505050505050505050919050565b600080600b54831015611728576040805162461bcd60e51b815260206004820181905260248201527f43616e6e6f742063616c63756c6174652066656520696e207468652070617374604482015290519081900360640190fd5b62015180600061173d620186a061016d611891565b9050600061174a81611915565b600a54600b549096509094505b868110156117ce57600061177b60046110768860065461183890919063ffffffff16565b905080611793886009546117d790919063ffffffff16565b11156117ae57826117a2578192505b6117ab83611915565b95505b620f424084886009540102816117c057fe5b049690960195508301611757565b50505050915091565b600082820183811015611831576040805162461bcd60e51b815260206004820152601b60248201527f536166654d6174683a206164646974696f6e206f766572666c6f770000000000604482015290519081900360640190fd5b9392505050565b600082611847575060006108e1565b8282028284828161185457fe5b04146118315760405162461bcd60e51b8152600401808060200182810382526021815260200180611bb86021913960400191505060405180910390fd5b600061183183836040518060400160405280601a81526020017f536166654d6174683a206469766973696f6e206279207a65726f000000000000815250611a84565b600061183183836040518060400160405280601e81526020017f536166654d6174683a207375627472616374696f6e206f766572666c6f770000815250611b26565b6007546107088215611a7e5782600e60019054906101000a90046001600160a01b03166001600160a01b031663557ed1ba6040518163ffffffff1660e01b815260040160206040518083038186803b15801561197057600080fd5b505afa158015611984573d6000803e3d6000fd5b505050506040513d602081101561199a57600080fd5b505110156119d95760405162461bcd60e51b8152600401808060200182810382526044815260200180611bd96044913960600191505060405180910390fd5b6000611a638261107686600e60019054906101000a90046001600160a01b03166001600160a01b031663557ed1ba6040518163ffffffff1660e01b815260040160206040518083038186803b158015611a3157600080fd5b505afa158015611a45573d6000803e3d6000fd5b505050506040513d6020811015611a5b57600080fd5b5051906118d3565b606590069050611a7a606461107685848303611838565b9250505b50919050565b60008183611b105760405162461bcd60e51b81526004018080602001828103825283818151815260200191508051906020019080838360005b83811015611ad5578181015183820152602001611abd565b50505050905090810190601f168015611b025780820380516001836020036101000a031916815260200191505b509250505060405180910390fd5b506000838581611b1c57fe5b0495945050505050565b60008184841115611b785760405162461bcd60e51b8152602060048201818152835160248401528351909283926044909101919085019080838360008315611ad5578181015183820152602001611abd565b50505090039056fe5661756c743a3a636c6f736528293a20636c6f736520616c6c6f776564206f6e6c792069662064656274206973207061796564206f6666536166654d6174683a206d756c7469706c69636174696f6e206f766572666c6f775661756c743a3a676574507269636528293a20496e636f72726563742073746174653a204c696d697420697320627265616368656420696e2074686520667574757265215661756c743a3a7061794f666628293a204d444c5920626f75676874206973206c657373207468616e2065787065637465645661756c743a3a7061794f666628293a206e6f7420657861637420616d6f756e74206f662045415520736f6c6420746f20627579204d444c595661756c743a3a62757928293a204e6f7420656e6f75676820746f6b656e7320746f2073656c6ca2646970667358221220e8fb88fb22c94932c417b5eb0d3a68371171f5836a7cc4c764a5bcf59aa4b54164736f6c63430007000033";

    public static final String FUNC_BORROW = "borrow";

    public static final String FUNC_BUY = "buy";

    public static final String FUNC_CLOSE = "close";

    public static final String FUNC_GETCOLLATERALINEAU = "getCollateralInEau";

    public static final String FUNC_GETCREDITLIMIT = "getCreditLimit";

    public static final String FUNC_GETPRICE = "getPrice";

    public static final String FUNC_GETPRINCIPAL = "getPrincipal";

    public static final String FUNC_GETSTATE = "getState";

    public static final String FUNC_GETTOTALDEBT = "getTotalDebt";

    public static final String FUNC_PAYOFF = "payOff";

    public static final String FUNC_SLASH = "slash";

    public static final Event PURCHASE_EVENT = new Event("Purchase", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected Vault(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Vault(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Vault(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Vault(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<PurchaseEventResponse> getPurchaseEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PURCHASE_EVENT, transactionReceipt);
        ArrayList<PurchaseEventResponse> responses = new ArrayList<PurchaseEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PurchaseEventResponse typedResponse = new PurchaseEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.price = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PurchaseEventResponse> purchaseEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, PurchaseEventResponse>() {
            @Override
            public PurchaseEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PURCHASE_EVENT, log);
                PurchaseEventResponse typedResponse = new PurchaseEventResponse();
                typedResponse.log = log;
                typedResponse.price = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PurchaseEventResponse> purchaseEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PURCHASE_EVENT));
        return purchaseEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> borrow(BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BORROW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> buy(BigInteger amount, BigInteger maxPrice, String to) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BUY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.generated.Uint256(maxPrice), 
                new org.web3j.abi.datatypes.Address(160, to)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> close() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CLOSE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getCollateralInEau() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCOLLATERALINEAU, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getCreditLimit() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCREDITLIMIT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getPrice() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETPRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getPrincipal() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETPRINCIPAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getTotalDebt(BigInteger time) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETTOTALDEBT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(time)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> payOff(BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PAYOFF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> slash() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SLASH, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Vault load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Vault(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Vault load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Vault(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Vault load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Vault(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Vault load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Vault(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Vault> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String owner, BigInteger stake, String token, BigInteger initialAmount, BigInteger tokenPrice, String timeProvider) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.generated.Uint256(stake), 
                new org.web3j.abi.datatypes.Address(160, token), 
                new org.web3j.abi.datatypes.generated.Uint256(initialAmount), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenPrice), 
                new org.web3j.abi.datatypes.Address(160, timeProvider)));
        return deployRemoteCall(Vault.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Vault> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String owner, BigInteger stake, String token, BigInteger initialAmount, BigInteger tokenPrice, String timeProvider) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.generated.Uint256(stake), 
                new org.web3j.abi.datatypes.Address(160, token), 
                new org.web3j.abi.datatypes.generated.Uint256(initialAmount), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenPrice), 
                new org.web3j.abi.datatypes.Address(160, timeProvider)));
        return deployRemoteCall(Vault.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Vault> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String owner, BigInteger stake, String token, BigInteger initialAmount, BigInteger tokenPrice, String timeProvider) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.generated.Uint256(stake), 
                new org.web3j.abi.datatypes.Address(160, token), 
                new org.web3j.abi.datatypes.generated.Uint256(initialAmount), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenPrice), 
                new org.web3j.abi.datatypes.Address(160, timeProvider)));
        return deployRemoteCall(Vault.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Vault> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String owner, BigInteger stake, String token, BigInteger initialAmount, BigInteger tokenPrice, String timeProvider) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.generated.Uint256(stake), 
                new org.web3j.abi.datatypes.Address(160, token), 
                new org.web3j.abi.datatypes.generated.Uint256(initialAmount), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenPrice), 
                new org.web3j.abi.datatypes.Address(160, timeProvider)));
        return deployRemoteCall(Vault.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class PurchaseEventResponse extends BaseEventResponse {
        public BigInteger price;

        public String to;

        public BigInteger amount;
    }
}
