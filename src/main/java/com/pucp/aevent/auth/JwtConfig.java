package com.pucp.aevent.auth;

public class JwtConfig {
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.123";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEpAIBAAKCAQEA3N0Uhzy0bhA6wdKadoe5bcf270GOWGe1HnDKJgvY71frIBwX\r\n" + 
			"2iFPwNGIO5Y1yrgegRTs7f1bUwBFCasDbjMFvjDD5b2/asVHoYjsL6neesa3Lngi\r\n" + 
			"xu0TkCpW4a0F3O5h8aqQz3qsFnt5I6Qn125dgjtaKjt/BSZBWyjj25diYHhrGYGl\r\n" + 
			"sUDMS1EgAcAL+sLnkXnu6DfjRHvIWKPbZgzGL7qEt6j10h2yo9zNT6554EhwXbWx\r\n" + 
			"mX3OdJyAAHskK9MrNgxqZbo74mSNtIaFjmsQPc3ID4erY8KLkG7RzOZXXKkBNkZJ\r\n" + 
			"mLGv3zPnlZwFVoj2T2r4k1U0NycDy439V5hERQIDAQABAoIBACJgwyY9u7P6ELtE\r\n" + 
			"pchXXfSJkJUzNg3qrpV7Zuu/Ilg27iFEXi4Uy04vDy5/NgZE3HKpKCvvKLzlqNlV\r\n" + 
			"ZiZMCNPO0V88RsQ+yuSI5IKSxU+FCNRR3M/r7QSeooFkJip6bIJqUzoIVSr2sydq\r\n" + 
			"EM2Gn0V7KZCzTBUoHDotRjJTAPwU2CINnape7WwMIkjqkdK5FviLvNCBNd8WjO7h\r\n" + 
			"6kia6+Nd0+5l2nhXpuKziFTQzXeJpU/izWXWm2OIpORo0aNLDnKlFL3DiZf75brT\r\n" + 
			"vSgvTmKNFt+bnY8H+M7ytlOiM64rQzaeACHqC7Wn7Tv2vDvkk6tfqvEsvg35knNS\r\n" + 
			"ia64Ve0CgYEA/W/3IKFVxzEiOs1XaL9BQ4/Oyy1MPK3MWtjLwXguEnhbzyMMZFlQ\r\n" + 
			"XCI7xBuULFvOIslgHOTWzJdUeArbbRlE/KQls0AEf4YWbbhreXyXcF7fIRmHleuz\r\n" + 
			"owdsakT22CXEx1NaIPqLhuyr8HU/tGmwYAUBGCI+tPkYnUdbi6qs5w8CgYEA3xjL\r\n" + 
			"zOlBh5Mnrz96w19ew/Zbk9njSNL0ShqP7BdyunwgXUnh4rOMO/iyc5MvwJ9Two/K\r\n" + 
			"BGpE2k9qTQvXObExNZQ/N8QbMDBM4JmrRZcysoU6jj/YJxHhfUdYpqmtAsf+3jcc\r\n" + 
			"4B5oeM8a8/EoFlYaBbDyFm0hdULvJVIbR9wZP2sCgYEAvLm6+taJjOq+xbER7VO2\r\n" + 
			"4vvdD5ns0qbNrb0RhkHbdS+hlo9P9A46dFGd1fx/i8TVrTvuUbXrarEqWrYjDowp\r\n" + 
			"vkTyOhhrARe17gDOL8qi7zAG0pwzRmYeAEJP7pbqhq0haxlb3YEVk+T8aPS2+r9V\r\n" + 
			"cztmxDUEIzn3pW908X2ogesCgYAaF7tWVv2sDqD4lTMVgKUDxF+HlldH4CxkMmEc\r\n" + 
			"2s03VGcwogCCVD+VkAvHCrLuE3RncAvPomI1Kk6jfjwI6ll4C8OtEQmhBDUpm691\r\n" + 
			"by6lxIFJu9vbDfNShLKwo22xwpRjhwyghc3wO0DKwSzQF/fpLH3T86WTImX39nds\r\n" + 
			"Wyi0ywKBgQDY5kFXDg2tHopbFpIMxxPoqDfIrvkNahFb3iXm8yV59DMR08UyUQKG\r\n" + 
			"ZFe6k4CheTnsjJ2VVWY3Q0WIUIZJX8khxPuWFgdrgWFTfAVu9I+NyDcg6gvxUALN\r\n" + 
			"oHLUzzIshroESDW6jo1qmlUQA7eZuHQqlw3cBLBoCpBVDKYP7Aj9FQ==\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public final static String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA3N0Uhzy0bhA6wdKadoe5\r\n" + 
			"bcf270GOWGe1HnDKJgvY71frIBwX2iFPwNGIO5Y1yrgegRTs7f1bUwBFCasDbjMF\r\n" + 
			"vjDD5b2/asVHoYjsL6neesa3Lngixu0TkCpW4a0F3O5h8aqQz3qsFnt5I6Qn125d\r\n" + 
			"gjtaKjt/BSZBWyjj25diYHhrGYGlsUDMS1EgAcAL+sLnkXnu6DfjRHvIWKPbZgzG\r\n" + 
			"L7qEt6j10h2yo9zNT6554EhwXbWxmX3OdJyAAHskK9MrNgxqZbo74mSNtIaFjmsQ\r\n" + 
			"Pc3ID4erY8KLkG7RzOZXXKkBNkZJmLGv3zPnlZwFVoj2T2r4k1U0NycDy439V5hE\r\n" + 
			"RQIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";
}
