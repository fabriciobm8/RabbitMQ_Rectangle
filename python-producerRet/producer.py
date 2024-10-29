# producer.py
import pika
import json

# Conectar ao RabbitMQ
connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
channel = connection.channel()

# Declarar a fila
channel.queue_declare(queue='retangulo')

# Solicitar dados do usuário
base = float(input("Digite a base do retângulo: "))
altura = float(input("Digite a altura do retângulo: "))

# Criar uma mensagem JSON com os dados
message = json.dumps({"base": base, "altura": altura})

# Enviar a mensagem para a fila 'retangulo'
channel.basic_publish(exchange='',
                      routing_key='retangulo',
                      body=message)
print(f" [x] Sent '{message}'")

# Fechar a conexão
connection.close()
