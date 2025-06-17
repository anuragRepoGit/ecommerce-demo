@SpringBootTest
class InventoryServiceTest {

    @Autowired
    private InventoryService inventoryService;

    @MockBean
    private ItemRepository itemRepository;

    @MockBean
    private InventoryRepository inventoryRepository;

    @MockBean
    private ReservationRepository reservationRepository;

    @MockBean
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void testAddSupply() {
        Long itemId = 1L;

        // mock item
        Item mockItem = new Item();
        mockItem.setId(itemId);
        mockItem.setName("Test Item");

        Inventory inventory = new Inventory();
        inventory.setItem(mockItem);
        inventory.setTotalQuantity(0);
        inventory.setReservedQuantity(0);

        // mocking DB calls
        when(itemRepository.findById(itemId)).thenReturn(Optional.of(mockItem));
        when(inventoryRepository.findByItemId(itemId)).thenReturn(Optional.empty());
        when(inventoryRepository.save(any(Inventory.class))).thenReturn(inventory);

        // act
        inventoryService.addSupply(itemId, 50);

        // assert
        verify(inventoryRepository, times(1)).save(any(Inventory.class));
    }
}
