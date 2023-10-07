from bitcoin.rpc import RawProxy

# 테스트넷에서 작동하도록 RawProxy 초기화
p = RawProxy(service_port=18332)

# 탐색할 주소 설정
address_to_check = 'mp5eDBnzVsKWBX5T1qNBmkuDiPwFxdYBxk'

# 잔액 초기화
balance = 0

# 최신 블록 높이 가져오기
latest_block_height = p.getblockcount()

# 모든 블록을 탐색 (제네시스 블록은 건너뜀)
for block_height in range(1, latest_block_height + 1):
    # 진행 정보 출력
    print(f"Checking block {block_height} of {latest_block_height}")

    # 블록 해시 가져오기
    block_hash = p.getblockhash(block_height)

    # 블록 정보 가져오기
    block = p.getblock(block_hash)

    # 블록의 모든 트랜잭션을 탐색
    for tx_id in block['tx']:
        print(f"Checking transaction {tx_id}")  # 진행 정보 출력

        # 트랜잭션 정보 가져오기
        tx_info = p.getrawtransaction(tx_id, 1)

        # 트랜잭션의 모든 출력을 탐색
        for output in tx_info['vout']:
            if 'addresses' in output['scriptPubKey']:
                for address in output['scriptPubKey']['addresses']:
                    if address == address_to_check:
                        balance += int(output['value'] * 1e8)

        # 트랜잭션의 모든 입력을 탐색
        for input_tx in tx_info['vin']:
            # 코인베이스 트랜잭션은 건너뛰기
            if 'txid' not in input_tx:
                continue

            input_tx_info = p.getrawtransaction(input_tx['txid'], 1)
            input_output = input_tx_info['vout'][input_tx['vout']]

            if 'addresses' in input_output['scriptPubKey']:
                for address in input_output['scriptPubKey']['addresses']:
                    if address == address_to_check:
                        balance -= int(input_output['value'] * 1e8)

print(f"The balance for address {address_to_check} is {balance / 1e8} BTC.")
