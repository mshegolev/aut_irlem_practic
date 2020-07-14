# Run tests
## Use Maven
Open a console and run:
    ./mvn test
# Jenkins configuration
## Encrypt
    tar cz folder_to_encrypt | \
      openssl enc -aes-256-cbc -e > out.tar.gz.enc
## Decrypt
    openssl enc -aes-256-cbc -d -in out.tar.gz.enc | tar xz"
