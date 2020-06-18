void setup() {
  Serial.begin(9600);
  pinMode(LED_BUILTIN, OUTPUT);
  pinMode(3, INPUT_PULLUP);
}

void loop() {
  byte leitura = digitalRead(3);
  if (!leitura)
    Serial.println("0");
  digitalWrite(13, !leitura);
  delay(200);
}
